package com.boj.gold.q12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static Integer[][] things, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        things = new Integer[N][2];
        dp = new Integer[N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            things[i] = new Integer[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        System.out.println(knapsack(N-1, K));
    }

    static int knapsack(int i, int k) {
        if (i < 0)
            return 0;
        if (dp[i][k] == null) {
            if (things[i][0] > k)
                dp[i][k] = knapsack(i - 1, k);
            else
                dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - things[i][0]) + things[i][1]);
        }
        return dp[i][k];
    }
}
