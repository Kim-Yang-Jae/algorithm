package com.boj.gold.q10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, sum;
    static long[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % M;
            cnt[sum]++;
        }
        long result = cnt[0];

        for (int i = 0; i < M; i++) {
            result += (cnt[i] * (cnt[i] - 1)) / 2;
        }

        System.out.println(result);
    }
}
