package com.boj.silver.q16935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * BOJ Q16935 배열 돌리기3
 */
public class Main {
    public static int N, M, R;
    public static int[][] matrix;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        String input = br.readLine();
        printResult(input);
        br.close();

    }

    public static void printResult(String input) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(input);
        int[][] resultMatrix;
        for (int i = 0; i < R; i++) {
            int operation = Integer.parseInt(st.nextToken());

            switch (operation) {
                case 1:
                case 2:
                    matrix = reverseMatrix(operation);
                    break;
                case 3:
                case 4:
                    matrix = rotateMatrix(operation);
                    break;
                case 5:
                case 6:
                    matrix = rotateQuarter(operation);
                    break;
            }
        }

        for (int[] arr : matrix) {
            for (int num : arr) {
                bw.write(num + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

    public static int[][] reverseMatrix(int operation) {
        int tmpN = matrix.length;
        int tmpM = matrix[0].length;
        int[][] resultMatrix = new int[tmpN][tmpM];
        for (int i = 0; i < tmpN; i++) {
            for (int j = 0; j < tmpM; j++) {
                int tmpI = 0, tmpJ = 0;
                if (operation == 1) {
                    tmpI = tmpN - 1 - i;
                    tmpJ = j;
                } else if (operation == 2) {
                    tmpI = i;
                    tmpJ = tmpM - 1 - j;
                }
                resultMatrix[tmpI][tmpJ] = matrix[i][j];
            }
        }
        return resultMatrix;
    }

    public static int[][] rotateMatrix(int operation) {
        int tmpN = matrix[0].length;
        int tmpM = matrix.length;
        int[][] resultMatrix = new int[tmpN][tmpM];
        for (int i = 0; i < tmpN; i++) {
            for (int j = 0; j < tmpM; j++) {
                int tmpI = 0, tmpJ = 0;
                if (operation == 4) {
                    tmpI = j;
                    tmpJ = tmpN - 1 - i;
                } else if (operation == 3) {
                    tmpI = tmpM - 1 - j;
                    tmpJ = i;
                }
                resultMatrix[i][j] = matrix[tmpI][tmpJ];
            }
        }
        return resultMatrix;
    }

    public static int[][] rotateQuarter(int operation) {
        int tmpN = matrix.length;
        int tmpM = matrix[0].length;
        int[][] resultMatrix = new int[tmpN][tmpM];
        if (operation == 5) {
            for (int i = 0; i < tmpN; i++) {
                for (int j = 0; j < tmpM; j++) {
                    int tmpI = i, tmpJ = j;
                    if (i < tmpN / 2) {
                        if (j < tmpM / 2)
                            tmpJ = j + tmpM / 2;
                        else
                            tmpI = i + (tmpN / 2);
                    } else {
                        if (j < tmpM / 2)
                            tmpI = i - (tmpN / 2);
                        else
                            tmpJ = j - (tmpM / 2);
                    }
                    resultMatrix[tmpI][tmpJ] = matrix[i][j];
                }
            }
        } else if (operation == 6) {
            for (int i = 0; i < tmpN; i++) {
                for (int j = 0; j < tmpM; j++) {
                    int tmpI = i, tmpJ = j;
                    if (i < tmpN / 2) {
                        if (j < tmpM / 2)
                            tmpI = i + tmpN / 2;
                        else
                            tmpJ = j - (tmpM / 2);
                    } else {
                        if (j < tmpM / 2)
                            tmpJ = j + (tmpM / 2);
                        else
                            tmpI = i - (tmpN / 2);

                    }
                    resultMatrix[tmpI][tmpJ] = matrix[i][j];
                }
            }
        }
        return resultMatrix;
    }
}
