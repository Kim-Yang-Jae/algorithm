package com.swea.q1954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            System.out.printf("#%d\n", tc);
            makeSnail(N);
        }
    }

    public static void makeSnail(int N) {
        int row = 0;
        int col = -1;
        int num = 1;
        int plus = 1;

        int[][] snail = new int[N][N];

        while (N > 0) {
            for (int i = 0; i < N; i++) {
                col += plus;
                snail[row][col] = num;
                num++;
            }
            N--;
            if (N == 0)
                break;
            for (int i = 0; i < N; i++) {
                row += plus;
                snail[row][col] = num;
                num++;
            }
            plus *= (-1);
        }

        printSnail(snail);

    }

    public static void printSnail(int[][] snail){
        for (int i = 0; i < snail.length; i++) {
            for (int j = 0; j < snail.length; j++) {
                System.out.print(snail[i][j] + " ");
            }
            System.out.println();
        }
    }
}
