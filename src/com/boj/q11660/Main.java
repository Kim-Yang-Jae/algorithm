package com.boj.q11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N + 1][N + 1];
        int[][] sum = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);

            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            int result = 0;
            input = br.readLine();
            st = new StringTokenizer(input);

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            if (startX == endX && startY==endY) {
                result = matrix[startX][startY];
            }else {
                result = sum[endX][endY] + sum[startX - 1][startY - 1] - sum[startX -1][endY] - sum[endX][startY-1];
            }

            System.out.println(result);
        }
        br.close();
    }
}
