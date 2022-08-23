package com.boj.gold.q7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ Q7576 토마토
 * BFS
 */
public class Main {
    static int N, M;
    static int[][] deltas = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } }; // 좌우앞뒤로 이동하기 위한 배열
    static int[][] box; // 토마토 보관 박스
    static Queue<Tomato> queue; // 다익은 토마토 객체를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken()); // 보관박스의 행
        N = Integer.parseInt(st.nextToken()); // 보관박스의 열
        box = new int[N][M];
        queue = new LinkedList<Tomato>();

        // 보관박스에 토마토 넣기
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                box[r][c] = Integer.parseInt(st.nextToken());
                if (box[r][c] == 1) // 다 익은 토마토는 큐에 저장
                    queue.offer(new Tomato(r, c, 1));
            }
        }
        // 처음부터 날짜를 1일로 저장했기 때문에 1빼주기, 토마토가 이미 다 익어있을 때 가장 큰값이 1이므로 1-1 = 0출력, 덜익은 토마토가 남아있으면 0 -1 = -1 출력
        sb.append(bfs() - 1);
        System.out.println(sb.toString());
    }// end of main method

    /**
     * 보관박스에서 토마토의 위치와 다 익은 날을 저장하는 객체 처음부터 다익은 토마토의 익은날을 1부터 시작하기 때문에 나중에 1을 빼줘야함
     */
    static class Tomato {
        int row, col, days;

        public Tomato(int row, int col, int days) {
            super();
            this.row = row;
            this.col = col;
            this.days = days;
        }
    }// end of Tomato class

    /**
     * 박스를 탐색하여 다익은 토마토 주변의 토마토를 익게 하고 토마토가 익은 마지막 날짜를 반환하는 재귀 메서드
     */
    static int bfs() {
        int maxDays = 0;
        while (!queue.isEmpty()) { // 큐가 모두 빌때까지 실행
            Tomato tomato = queue.poll(); // 큐에서 토마토 하나 꺼내기
            for (int d = 0; d < 4; d++) { // 사방탐색
                int tmpR = tomato.row + deltas[d][0];
                int tmpC = tomato.col + deltas[d][1];
                if (tmpR >= 0 && tmpR < N && tmpC >= 0 && tmpC < M && box[tmpR][tmpC] == 0) { // 박스에서 벗어나지 않고 아직 익지 않은
                    // 토마토일때
                    queue.offer(new Tomato(tmpR, tmpC, tomato.days + 1)); // 토마토를 큐에 저장
                    box[tmpR][tmpC] = tomato.days + 1; // 토마토를 익은상태로 변경
                }
            }
            maxDays = Math.max(maxDays, tomato.days);//토마토가 익은 날짜 비교해 가장 마지막 날짜 저장
        }
        if(isCheck())//덜 익은 토마토 있는지 탐색 없으면  0반환
            return maxDays;
        return 0;
    }// end of bfs method

    /**
     * 박스에 덜익은 토마토가 남아있으면 false 반환, 아니면 true
     * @return
     */
    static boolean isCheck() {
        Loop: for (int[] days : box) {
            for (int day : days) {
                if (day == 0) {// 덜익은 토마토가 남아있으면 확인을 멈추고 false 출력
                    return false;
                }
            }
        }
        return true;
    }// end of isCheck method
}// end of Main class
