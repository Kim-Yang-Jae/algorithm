package com.boj.silver.q16926;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * BOJ Q16926 배열 돌리기 1
 */
public class Main {
//	static int N, M, R;
//	static int[][] matrix;
//	static int[][] rotatedMatrix;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        int[][] rotatedMatrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotateMatrix(N, M, R, matrix, rotatedMatrix);

        for (int[] arr : rotatedMatrix) {
            for(int num : arr) {
                bw.write(num + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void rotateMatrix(int N, int M, int R, int[][] matrix, int[][] rotatedMatrix) {
        for(int num = 0; num<R; num++) {
            int row = 0;
            int col = 0;
            int plus = 1;
            int tmpRow = row;
            int tmpCol = col;
            int tmpN = N, tmpM = M;
            while (true) {
                for (int cnt = 0; cnt < 2; cnt++) {
                    for (int i = 0; i < tmpN - 1; i++) {
                        tmpRow = row + plus;
                        tmpCol = col;
                        rotatedMatrix[tmpRow][tmpCol] = matrix[row][col];
                        row += plus;
                    }
                    for (int i = 0; i < tmpM - 1; i++) {
                        tmpRow = row;
                        tmpCol = col + plus;
                        rotatedMatrix[tmpRow][tmpCol] = matrix[row][col];
                        col += plus;
                    }
                    plus *= (-1);
                }
                tmpM -= 2;
                tmpN -= 2;
                row++;
                col++;
                if(tmpN<=0 || tmpM<=0)
                    break;
            }
            matrix = deepCopy(rotatedMatrix);
        }
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
