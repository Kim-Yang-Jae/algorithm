package com.swea.q1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  SWEA Q1247 최적 경로
 *  순열
 *  회사 -> N명의 고객 -> 집 최단경로 구하기
 */
public class Solution {
    static int N, min;
    static int[][] destination; //회사, 집 , N명의 고객 좌표 저장
    static boolean[] visited; //방문 체크
    static int[] selected; //방문 순서 저장

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            destination = new int[N + 2][];
            visited = new boolean[N];
            selected = new int[N + 2];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N + 2; i++) { // 회사, 집, N명의 고객 입력
                destination[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            }
            selected[0] = 0; //방문 순서의 첫번째는 무조건 회사로 고정
            selected[N+1] = 1; //방문 순서의 마지막은 무조건 집으로 고정
            perm(0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }// end of main method

    /**
     * 방문 순서를 뽑는 순열 메서드
     * @param cnt 방문한 고객의 숫자
     */
    static void perm(int cnt) {
        if (cnt == N) { //모든 고객을 방문했으면 거리 구하기
            int distance = 0;
            for (int i = 0; i < N + 1; i++) {
                distance += getDistance(destination[selected[i]][0], destination[selected[i]][1],
                        destination[selected[i + 1]][0], destination[selected[i + 1]][1]);
            }
            min = Math.min(min, distance); // 최소거리 구하기
            return;
        }

        for (int index = 0; index < N; index++) {
            if (visited[index])
                continue;
            visited[index] = true;
            selected[cnt + 1] = index + 2;
            perm(cnt + 1);
            visited[index] = false;
        }

    }// end of perm method

    /**
     * 거리를 구하는 메서드
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return
     */
    static int getDistance(int row1, int col1, int row2, int col2) {
        return Math.abs(row1 - row2) + Math.abs(col1 - col2);
    }// end of getDistance method
}// end of Main class
