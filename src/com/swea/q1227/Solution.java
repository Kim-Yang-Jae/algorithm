package com.swea.q1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    // 미로 배열
    static int[][] map;
    // 방문 체크 배열
    static boolean[][] visited;
    // 상하좌우
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 시작점
    static int startRow, startCol;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            map = new int[100][100];
            visited = new boolean[100][100];

            for (int i = 0; i < 100; i++) {
                String input = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == '2') {
                        startRow = i;
                        startCol = j;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(dfs(startRow, startCol)).append("\n");
        }// end of testCase
        System.out.println(sb.toString());
    }//end of main

    // 목적지 도착시 1리턴, 못하면 0리턴
    static int dfs(int r, int c) {
        if(map[r][c] == '1' || visited[r][c])
            return 0;
        if(map[r][c] == '3')
            return 1;
        visited[r][c] = true; // 방문 체크
        int result = 0;
        for (int i = 0; i < 4 && result == 0; i++) {
            result = dfs(r+deltas[i][0], c+deltas[i][1]);
        }
        return result;
    }
}
