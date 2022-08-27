package com.boj.silver.q1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static char[][] board;
    static char[][] chessBoard;
    static char[][] chessBoard2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new char[M][N];
        chessBoard = makeChessBoard('B');
        chessBoard2 = makeChessBoard('W');


        for (int r = 0; r < M; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                board[r][c] = str.charAt(c);
            }
        }

        System.out.println(check());
    }

    static int check() {
        int minCnt = Integer.MAX_VALUE;
        for (int sr = 0; sr <= M - 8; sr++) {
            for (int sc = 0; sc <= N - 8; sc++) {
                int cnt1 = 0, cnt2 = 0;
                for (int r = sr; r < sr + 8; r++) {
                    for (int c = sc; c < sc + 8; c++) {
                        if (board[r][c] != chessBoard[r - sr][c - sc]) {
                            cnt1++;
                        }
                        if (board[r][c] != chessBoard2[r - sr][c - sc]) {
                            cnt2++;
                        }
                    }
                }
                minCnt = Math.min(minCnt, Math.min(cnt1, cnt2));
            }
        }
        return minCnt;
    }

    static char[][] makeChessBoard(char color1) {
        char[][] matrix = new char[8][8];
        char color2 = ' ';
        if (color1 == 'W')
            color2 = 'B';
        else
            color2 = 'W';
        for (int r = 0; r < 8; r += 2) {
            for (int c = 0; c < 8; c += 2) {
                matrix[r][c] = color1;
                matrix[r][c + 1] = color2;
                matrix[r + 1][c] = color2;
                matrix[r + 1][c + 1] = color1;
            }
        }
        return matrix;
    }

}
