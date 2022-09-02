package com.boj.silver.q1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, max;
    static int[] numbers;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        dp = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = numbers[0];
        max = numbers[0];

        topDown(n - 1);

        System.out.println(max);
    }

    static void bottomUp() {
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
            max = Math.max(dp[i], max);
        }
    }

    static int topDown(int num) {
        if (dp[num] == null) {
            dp[num] = Math.max(topDown(num - 1) + numbers[num], numbers[num]);
            max = Math.max(dp[num], max);
        }
        return dp[num];
    }
}
