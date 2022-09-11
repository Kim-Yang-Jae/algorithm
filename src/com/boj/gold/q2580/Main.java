package com.boj.gold.q2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sudoku;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sudoku = new int[9][9];

        for (int r = 0; r < 9; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 9; c++) {
                sudoku[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        fillBlankSudoku(0,0);

    }

    static void fillBlankSudoku(int row, int col) {
        if (col == 9) {
            fillBlankSudoku(row + 1, 0);
            return;
        }
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.print(sb);
            System.exit(0);
        }


        if (sudoku[row][col] == 0) {
            for (int num = 1; num <= 9; num++) {
                if (check(row, col, num)) {
                    sudoku[row][col] = num;
                    fillBlankSudoku(row, col + 1);
                }
            }
            sudoku[row][col] = 0;
            return;
        }

        fillBlankSudoku(row, col + 1);
    }

    static boolean check(int row, int col, int num) {
        for (int c = 0; c < 9; c++) {
            if (sudoku[row][c] == num)
                return false;
        }
        for (int r = 0; r < 9; r++) {
            if (sudoku[r][col] == num)
                return false;
        }
        int partRow = (row / 3) * 3;
        int partCol = (col / 3) * 3;
        for (int r = partRow; r < partRow + 3; r++) {
            for (int c = partCol; c < partCol + 3; c++) {
                if (sudoku[r][c] == num)
                    return false;
            }
        }

        return true;
    }
}
