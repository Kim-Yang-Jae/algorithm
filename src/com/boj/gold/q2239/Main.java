package com.boj.gold.q2239;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] sudoku;
    static List<int[]> list;
    static boolean isCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sudoku = new int[9][9];
        list = new ArrayList<>();

        for (int r = 0; r < 9; r++) {
            String numbers = br.readLine();
            for (int c = 0; c < 9; c++) {
                sudoku[r][c] = numbers.charAt(c) - '0';
                if (sudoku[r][c] == 0)
                    list.add(new int[]{r, c});
            }
        }

        dfs(0);

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                bw.write(sudoku[r][c] + "");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cnt) {
        if (cnt == list.size()) {
            isCheck = true;
            return;
        }

        int r = list.get(cnt)[0];
        int c = list.get(cnt)[1];
        for (int i = 1; i < 10; i++) {
            if (check(r, c, i)) {
                sudoku[r][c] = i;
                dfs(cnt + 1);
            }
            if (isCheck)
                return;
            sudoku[r][c] = 0;
        }

    }

    static boolean check(int r, int c, int n) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][c] == n || sudoku[r][i] == n)
                return false;
        }
        int nr = ((r / 3) * 3), nc = (c - (c % 3));
        for (int tmpR = nr; tmpR < nr + 3; tmpR++) {
            for (int tmpC = nc; tmpC < nc + 3; tmpC++) {
                if (sudoku[tmpR][tmpC] == n)
                    return false;
            }
        }
        return true;
    }

}
