package com.swea.q2001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int T = Integer.parseInt(input);

        for (int tc = 1; tc <= T; tc++) {
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                input = br.readLine();
                st = new StringTokenizer(input);
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write("#" + tc + " " + calcMaxFly(M, matrix) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static int calcMaxFly(int M, int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length - M + 1; i++) {
            for (int j = 0; j < matrix.length - M + 1; j++) {
                if ((i + M) <= matrix.length && (j + M) <= matrix.length) {
                    int killCnt = 0;
                    for (int x = 0; x < M; x++) {
                        for (int y = 0; y < M; y++) {
                            killCnt += matrix[i + x][j + y];
                        }
                    }
                    max = Math.max(killCnt, max);
                }
            }
        }

        return max;
    }
}

