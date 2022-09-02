package com.boj.silver.q1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, r;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        dp = new int[30][30];

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            sb.append(comb(n,r)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int comb(int n, int r) {
        if (dp[n][r] > 0)
            return dp[n][r];
        if (n == r || r == 0)
            return dp[n][r] = 1;
        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}
