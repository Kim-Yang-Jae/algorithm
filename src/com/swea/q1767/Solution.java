package com.swea.q1767;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int N, coreCnt, maxCoreCnt, minLineCnt;
    static int[][] board;
    static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static Coordinate[] cores, selectedCore;
    static boolean[] isSelected;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            coreCnt = 0;
            maxCoreCnt = -1;
            minLineCnt = Integer.MAX_VALUE;
            board = new int[N][N];
            cores = new Coordinate[12];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    board[r][c] = Integer.parseInt(st.nextToken());
                    if (board[r][c] == 1) {
                        if (r == 0 || r == N - 1 || c == 0 || c == N - 1)
                            continue;
                        cores[coreCnt++] = new Coordinate(r, c);
                    }
                }
            }
            isSelected = new boolean[coreCnt];
            selectCore(0);

            sb.append("#").append(tc).append(" ").append(minLineCnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Coordinate {
        int row, col;

        public Coordinate(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }
    }

    static void selectCore(int cnt) {
        if (cnt == coreCnt) {
            int[][] copyBoard = deepCopy();
            selectedCore = new Coordinate[12];
            int index = 0;
            for (int i = 0; i < isSelected.length; i++) {
                if (isSelected[i] == true) {
                    selectedCore[index++] = cores[i];
                }
            }
            if (index > 0) {
                checkLine(0, index, copyBoard, 0);
            }
            return;
        }
        isSelected[cnt] = true;
        selectCore(cnt + 1);
        isSelected[cnt] = false;
        selectCore(cnt + 1);
    }

    static void checkLine(int cnt, int index, int[][] copyBoard, int minLine) {
        if (cnt == index) {
            if (maxCoreCnt < index) {
                maxCoreCnt = index;
                minLineCnt = minLine;
            } else if (maxCoreCnt == index) {
                minLineCnt = Math.min(minLineCnt, minLine);
            }
            return;
        }
        Coordinate core = selectedCore[cnt];
        int row = core.row, col = core.col;
        Coordinate[] lines = new Coordinate[N];
        for (int d = 0; d < 4; d++) {
            boolean isCheck = true;
            int lineCnt = 0;
            int tmpR = row, tmpC = col;
            while (true) {
                tmpR += deltas[d][0];
                tmpC += deltas[d][1];
                if (tmpC < 0 || tmpC >= N || tmpR < 0 || tmpR >= N) {
                    break;
                }
                if (copyBoard[tmpR][tmpC] == 0) {
                    lines[lineCnt++] = new Coordinate(tmpR, tmpC);
                } else {
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) {
                for (int i = 0; i < lineCnt; i++) {
                    Coordinate coordinate = lines[i];
                    copyBoard[coordinate.row][coordinate.col] = 2;
                }
                checkLine(cnt + 1, index, copyBoard, minLine + lineCnt);
                for (int i = 0; i < lineCnt; i++) {
                    Coordinate coordinate = lines[i];
                    copyBoard[coordinate.row][coordinate.col] = 0;
                }
            }

        }
    }

    static int[][] deepCopy() {
        int[][] copyBoard = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                copyBoard[r][c] = board[r][c];
            }
        }
        return copyBoard;
    }
}