package com.exercise.q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        coloring(N);

        System.out.println(dp[N]);
        br.close();
    }

    static void coloring(int num){
        dp[1] = 2;
        if(num > 1)
            dp[2] = 3;
        if(num > 2) {
            for (int i = 3; i <= num; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
    }
}
