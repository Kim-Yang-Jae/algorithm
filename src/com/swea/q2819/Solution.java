package com.swea.q2819;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *  Q2819 격자판의 숫자 이어 붙이기
 *  순열
 */
public class Solution {
    static char[][] matrix; //격자판 저장 배열
    static char[] number; //지나간 숫자 저장 배열
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; //동서남북 이동을 위한 배열
    static Set<String> numSet; //중복방지를 위한 set

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            matrix = new char[4][4];
            number = new char[7];
            numSet = new HashSet<>();

            for (int r = 0; r < 4; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 4; c++) {
                    matrix[r][c] = st.nextToken().charAt(0);
                }
            }

            for (int r = 0; r < 4; r++) { //격자판 완전탐색
                for (int c = 0; c < 4; c++) {
                    number[0] = matrix[r][c]; //첫번째 자리 숫자는 시작점으로 지정
                    perm(1, r, c);// 다음 숫자 찾기
                }
            }
            bw.write("#" + tc + " " + numSet.size() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 순열을 이용해 나올수 있는 숫자를 찾아주는 메서드
     * @param cnt 뽑은 숫자 수
     * @param row 격자판 행
     * @param col 격자판 열
     */
    static void perm(int cnt, int row, int col) {
        if (cnt == 7) { //7개의 숫자 다 뽑았으면 숫자를 set에 저장하여 중복 판단 후 메서드 종료
            numSet.add(String.valueOf(number));
            return;
        }
        for (int d = 0; d < 4; d++) { //동서남북 방위 모두 확인
            int tmpR = row + deltas[d][0]; //바뀐 행
            int tmpC = col + deltas[d][1]; //바뀐 열
            if (tmpR < 0 || tmpC < 0 || tmpR >= 4 || tmpC >= 4) //범위를 벗어나면 다른 방향으로
                continue;
            number[cnt] = matrix[tmpR][tmpC]; //숫자 뽑기
            perm(cnt + 1, tmpR, tmpC); //다음 숫자 뽑기 위한 재귀함수
        }
    }
}
