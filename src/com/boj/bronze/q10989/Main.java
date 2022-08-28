package com.boj.bronze.q10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] counting = new int[10_001];

        for (int i = 0; i < N; i++) {
            counting[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < 10001; i++) {
            sb.append(i).append("\n");
            counting[i]--;
        }

        System.out.println(sb.toString());
        br.close();
    }
}

