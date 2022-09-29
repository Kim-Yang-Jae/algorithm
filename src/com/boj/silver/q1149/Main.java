package com.boj.silver.q1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] colors;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        colors = new int[N + 1][3];
        dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][0] = colors[1][0];
        dp[1][1] = colors[1][1];
        dp[1][2] = colors[1][2];

        System.out.println(Math.min(recursion(N, 0), Math.min(recursion(N, 1), recursion(N, 2))));
        System.out.println(loop(N));
    }

    static int recursion(int num, int index) {
        if (dp[num][index] == 0) {
            switch (index) {
                case 0:
                    dp[num][index] = Math.min(recursion(num - 1, 1), recursion(num - 1, 2)) + colors[num][index];
                    break;
                case 1:
                    dp[num][index] = Math.min(recursion(num - 1, 0), recursion(num - 1, 2)) + colors[num][index];
                    break;
                case 2:
                    dp[num][index] = Math.min(recursion(num - 1, 0), recursion(num - 1, 1)) + colors[num][index];
                    break;
            }
        }
        return dp[num][index];
    }

    static int loop(int num) {
        for (int i = 2; i <= num; i++) {
            colors[i][0] += Math.min(colors[i - 1][1], colors[i - 1][2]);
            colors[i][1] += Math.min(colors[i - 1][0], colors[i - 1][2]);
            colors[i][2] += Math.min(colors[i - 1][0], colors[i - 1][1]);

        }
        return Math.min(colors[num][0], Math.min(colors[num][1], colors[num][2]));
    }
}
