package com.boj.bronze.q2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ Q2563 색종이
 */
public class Main {
    public static boolean[][] drawingPaper;
    public static int[][] startPoint;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfColoredPaper = Integer.parseInt(br.readLine());
        drawingPaper = new boolean[100][100];
        startPoint = new int[numOfColoredPaper][2];

        int count = 0;
        for (int num = 0; num < numOfColoredPaper; num++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            startPoint[num][0] = Integer.parseInt(st.nextToken());
            startPoint[num][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(calcAreaOfColoredPaper());
    }

    public static int calcAreaOfColoredPaper() {
        int count = 0;
        for (int[] ints : startPoint) {
            for (int i = ints[0]; i < ints[0] + 10; i++) {
                for (int j = ints[1]; j < ints[1] + 10; j++) {
                    if (!drawingPaper[i][j]) {
                        drawingPaper[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
