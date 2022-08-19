package com.boj.gold.q17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  BOJ Q17135 캐슬 디펜스
 *  조합, 구현
 */
public class Main {
    static int N, M, D, totalCount;
    static char[][] map;
    static int[][] kill; //궁수가 서로 같은 적을 죽일 수 있기 때문에 타겟을 모아놓고 한꺼번에 발사하기
    static Archer[] archers; //궁수의 위치 조합을 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new char[N + 1][M];
        archers = new Archer[3];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = st.nextToken().charAt(0);
            }
        }
        comb(0, 0);
        System.out.println(totalCount);
    }// end of main method

    /**
     *  궁수의 좌표를 저장하기 위한 클래스
     */
    static class Archer {
        int r, c;

        public Archer(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }// end of Archer class

    /**
     * 궁수의 위치를 뽑는 조합 메서드
     * @param cnt 뽑은 궁수의 수
     * @param index 궁수를 배치할 수 있는 성 인덱스
     */
    static void comb(int cnt, int index) {
        if (cnt == 3) {
            myTurn();
            return;
        }
        if (index >= M)
            return;
        archers[cnt] = new Archer(N, index); //궁수의 좌표를 배열에 저장
        comb(cnt + 1, index + 1);
        comb(cnt, index + 1);
    }// end of comb method

    /**
     * 궁수를 배치하여 적을 처리하는 메서드
     */
    static void myTurn() {
        char[][] copyMap = deepCopy(); //깊은 복사를 통해 원래 map() 복사
        int count = 0; //궁수 조합에 따른 처치한 적수를 구하기 위한 변수

        while (isCheck(copyMap)) { //copyMap에 1이 남아있지 않을 때까지 반복
            kill = new int[3][2]; //궁수가 처치할 적 배열 초기화
            for (int i = 0; i < 3; i++) { //궁수 한명씩 처치할 적 탐색
                int r = N - 1; //성 바로 앞부터 시작
                int nearestEnemyR = N + 1, nearestEnemyC = M + 1, minDistance = D; //가장 가까운 적의 좌표와 거리 저장 변수

                while (getDistance(archers[i].r, archers[i].c, r, archers[i].c) <= D && r>=0) { //r이 범위를 벗어나지 않고 궁수의 사정거리를 벗어나지 않은 상태에서 반복
                    for (int c = 0; c < M; c++) { //r번째 줄에서 처치할 적 탐색
                        if (copyMap[r][c] == '1') { //적이 있으면
                            int distance = getDistance(archers[i].r, archers[i].c, r, c); //거리 측정
                            if (distance < minDistance) { //사정거리 안이면 좌표와 거리 바꾸기
                                nearestEnemyR = r;
                                nearestEnemyC = c;
                                minDistance = distance;
                            } else if (distance == minDistance) { // 사정거리와 같으면
                                if (nearestEnemyC > c) { // 가장 왼쪽에 있는 적으로 처치
                                    nearestEnemyR = r;
                                    nearestEnemyC = c;
                                }
                            }
                        }
                    }
                    r--; //다음 줄로 변경
                }
                if (nearestEnemyR == N + 1) //처치할 적이 없으면 다음 궁수로
                    continue;
                kill[i][0] = nearestEnemyR; //처치할 적의 row 를 kill 배열에 저장
                kill[i][1] = nearestEnemyC; //처치할 적의 row 를 kill 배열에 저장
            }
            for (int i = 0; i < 3; i++) { //처치할 적 배열에서 하나씩 꺼내서 처치
                if(kill[i][0] != 0 && copyMap[kill[i][0]][kill[i][1]] == '1'){ // 배열이 비어있는 지 확인 및 다른 궁수가 이미 죽였는지 확인
                    copyMap[kill[i][0]][kill[i][1]] = '0'; //적 처치
                    count++;
                }
            }
            enemyTurn(copyMap); //적의 이동하여 다음 턴으로 넘어가는 메서드
        }
        totalCount = Math.max(totalCount, count); //가장 적을 많이 처치한 경우의 수 세기
    }// end of myTurn method

    /**
     * 적군이 이동하여 다음 턴으로 넘어가도록 하는 메서드
     * @param matrix 현재 맵
     */
    static void enemyTurn(char[][] matrix) {
        for (int r = N - 1; r > 0; r--) { //깊은 복사를 이용하여 맵을 한칸씩 내려줌
            matrix[r] = matrix[r - 1].clone();
        }
        for (int i = 0; i < M; i++) {//가장 윗줄은 0으로 채워줌
            matrix[0][i] = '0';
        }
    }// end of enemyTurn method

    /**
     * 맵에 적이 있는 지 확인하여 게임을 끝을 결정하는 메서드
     * @param matrix 현재 맵
     * @return 게임의 종료 여부
     */
    static boolean isCheck(char[][] matrix) {
        boolean check = false;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (matrix[r][c] == '1') //1이 있으면 게임 계속 없으면 종료
                    check = true;
            }
        }
        return check;
    }

    /**
     * 두 좌표 사이의 거리를 계산하는 메서드
     * @param r1
     * @param c1
     * @param r2
     * @param c2
     * @return
     */
    static int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }// end of getDistance method

    /**
     * 이차원 배열의 깊은 복사 메서드
     * @return 복사된 이차원 배열
     */
    static char[][] deepCopy() {
        char[][] copyMap = new char[N + 1][M];
        for (int i = 0; i < N; i++) {
            if (M >= 0)
                System.arraycopy(map[i], 0, copyMap[i], 0, M);
        }
        return copyMap;
    }// end of deepCopy method
}// end of Main class
