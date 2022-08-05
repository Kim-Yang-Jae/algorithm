package com.boj.silver.q11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numArr =new int[N+1];
        int[] sumArr = new int[N+1];

        input = br.readLine();
        st = new StringTokenizer(input);
        for(int i = 1; i<=N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i-1] + numArr[i];
        }

        for(int i = 1; i<=M; i++) {
            int sum = 0;
            input = br.readLine();
            st = new StringTokenizer(input);
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            sum = sumArr[endIndex] - sumArr[startIndex-1];

            System.out.println(sum);
        }
    }
}

