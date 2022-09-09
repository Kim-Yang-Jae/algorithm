package com.boj.gold.q17425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] dp, totalSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        dp = new long[1_000_001];
        totalSum = new long[1_000_0001];
        Arrays.fill(dp, 1);
        getTotalDivisorSum();

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(totalSum[N]).append("\n");
        }
        System.out.println(sb);
    }

    static void getTotalDivisorSum() {
        for (int i = 2; i <= 1_000_000; i++) {
            for (int j = 1; i * j <= 1_000_000; j++) {
                dp[i * j] += i;
            }
        }

        for (int i = 1; i <= 1_000_000; i++) {
            totalSum[i] = totalSum[i - 1] + dp[i];
        }
    }
}
