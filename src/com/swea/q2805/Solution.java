package com.swea.q2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[][] field = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    field[i][j] = line.charAt(j) - '0';
                }
            }

            int result = calcYeild(field);
            System.out.printf("#%d %d\n", test_case, result);

        }
    }

    public static int calcYeild(int[][] field) {
        int sum = 0;
        int center = (field.length / 2);
        for (int i = 0; i < field.length; i++) {
            if (i <= center) {
                for (int j = center - i; j <= center + i; j++) {
                    sum += field[i][j];
                }
            } else {
                for (int j = center - (field.length - i - 1); j <= center + (field.length - i - 1); j++) {
                    sum += field[i][j];
                }
            }
        }
        return sum;
    }
}
