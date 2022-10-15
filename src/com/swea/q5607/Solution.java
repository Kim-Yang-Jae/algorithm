package com.swea.q5607;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static final long mod = 1234567891L;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = null;
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();

            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            dp = new long[n + 1];
            dp[1] = 1;

            for (int i = 2; i <= n; i++)
                dp[i] = (dp[i - 1] * i) % mod;

            long denominator = (dp[n - r] * dp[r]) % mod;
            long exponent = littleTheorem(denominator, mod - 2);
            long result = (dp[n] * exponent) % mod;
            sb.append("#").append(tc).append(" ").append(result);
            System.out.println(sb.toString());
        }
        br.close();
    }

    static long littleTheorem(long denominator, long exponent) {
        if (exponent == 0)
            return 1;
        else if (exponent == 1)
            return denominator;

        if (exponent % 2 == 0) {
            long num = littleTheorem(denominator, exponent / 2);
            return (num * num) % mod;
        } else {
            long num = littleTheorem(denominator, exponent - 1);
            return (num * denominator) % mod;
        }
    }
}
