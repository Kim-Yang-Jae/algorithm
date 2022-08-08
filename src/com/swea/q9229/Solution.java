package com.swea.q9229;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA Q9229 한빈이와 Spot Mart
 */
public class Solution {
    static int[] snackWeight;
    static int[] numbers;
    static int maxSum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            snackWeight = new int[N];
            numbers = new int[2];
            maxSum = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                snackWeight[i] = Integer.parseInt(st.nextToken());
            }

            calcMaxComb(0, 0, N, M);
            if (maxSum == 0)
                bw.write("#" + tc + " " + (-1) + "\n");
            else{
                bw.write("#" + tc + " " + maxSum + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void calcMaxComb(int cnt, int start, int N, int M) {
        int sum = 0;
        if (cnt == 2) {
            for (int i = 0; i < 2; i++) {
                sum += numbers[i];
            }
            if(sum <= M)
                maxSum = Math.max(maxSum, sum);
            return;
        }
        for (int i = start; i < N; i++) {
            numbers[cnt] = snackWeight[i];
            calcMaxComb(cnt + 1, i + 1, N, M);
        }
    }
}
