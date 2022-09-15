package com.boj.silver.q1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(getZeroOneTile(N));

    }

    static long getZeroOneTile(int N) {
        if (dp[N] == 0 && N != 0 && N != 1 && N != 2)
            dp[N] = (getZeroOneTile(N - 1) + getZeroOneTile(N - 2))% 15746;
        return dp[N];
    }
}
