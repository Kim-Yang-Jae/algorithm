package com.boj.silver.q2961;


import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ Q2961 도영이가 만든 맛있는 음식
 */
public class Main {
    static int N;
    static int[][] gradients;
    static int minDifference;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        gradients = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            gradients[i][0] = Integer.parseInt(st.nextToken());
            gradients[i][1] = Integer.parseInt(st.nextToken());
        }

        minDifference = Integer.MAX_VALUE;
        calcMinDifference(0, 1, 0);
        bw.write(minDifference + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void calcMinDifference(int cnt, int sour, int bitter) {
        if (cnt == N) {
            if(bitter != 0)
                minDifference = Math.min(minDifference, Math.abs(bitter - sour));
            return;
        }

        calcMinDifference(cnt + 1, sour * gradients[cnt][0], bitter + gradients[cnt][1]);
        calcMinDifference(cnt + 1, sour, bitter);
    }
}
