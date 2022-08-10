package com.boj.gold.q17406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, min;
    static int[][] matrix;
    static boolean[] isSelected;
    static int[][] input;
    static int[][] selected;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        matrix = new int[N + 1][M + 1];
        isSelected = new boolean[K];
        selected = new int[K][3];
        input = new int[K][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int tc = 0; tc < K; tc++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            input[tc] = new int[]{r, c, s};
        }
        permutation(0);
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void permutation(int cnt) {
        if (cnt == K) {
            int[][] nMatrix = deepCopy(matrix);
            for (int[] ints : selected) {
                int r = ints[0];
                int c = ints[1];
                int s = ints[2];
                nMatrix = calcPartialRotateMatrix(r, c, s, nMatrix);
            }
            min = Math.min(min, calcMinMatrix(nMatrix));
            return;
        }
        for (int i = 0; i < K; i++) {
            if (isSelected[i])
                continue;
            selected[cnt] = input[i];
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }

    }

    public static int[][] calcPartialRotateMatrix(int r, int c, int s, int[][] inputMatrix) {
        int[][] resultMatrix = deepCopy(inputMatrix);
        int row = r - s;
        int col = c - s;
        int plus = 1;
        int tmpRow = row, tmpCol = col;
        int length = 2 * s + 1;
        do {
            for (int cnt = 0; cnt < 2; cnt++) {
                for (int i = 0; i < length - 1; i++) {
                    tmpRow = row;
                    tmpCol = col + plus;
                    resultMatrix[tmpRow][tmpCol] = inputMatrix[row][col];
                    col += plus;
                }
                for (int i = 0; i < length - 1; i++) {
                    tmpRow = row + plus;
                    tmpCol = col;
                    resultMatrix[tmpRow][tmpCol] = inputMatrix[row][col];
                    row += plus;
                }
                plus *= (-1);
            }
            length -= 2;
            row++;
            col++;
        } while (length > 1);

        return resultMatrix;
    }

    public static int calcMinMatrix(int[][] inputMatrix) {
        int minNum = Integer.MAX_VALUE;
        for (int[] arr : inputMatrix) {
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            if (sum != 0) {
                minNum = Math.min(sum, minNum);
            }
        }
        return minNum;
    }

    public static int[][] deepCopy(int[][] original2) {
        if(original2 == null) return null;
        int[][] result = new int[original2.length][original2[0].length];

        for(int i=0; i<original2.length; i++){
            System.arraycopy(original2[i], 0, result[i], 0, original2[0].length);
        }

        return result;
    }
}
