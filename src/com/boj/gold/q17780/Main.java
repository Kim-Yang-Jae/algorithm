package com.boj.gold.q17780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] board;
    static Piece[] pieces;
    static ArrayList<Integer>[][] pieceList;
    static int[][] deltas = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N + 1][N + 1];
        pieceList = new ArrayList[N + 1][N + 1];
        pieces = new Piece[K + 1];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                pieceList[r][c] = new ArrayList<>();
            }
        }

        for (int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int direct = Integer.parseInt(st.nextToken());
            pieces[k] = new Piece(r, c, direct);
            pieceList[r][c].add(k);
        }

        System.out.println(turn());

    }

    static class Piece {
        int r, c, direct;

        public Piece(int r, int c, int direct) {
            this.r = r;
            this.c = c;
            this.direct = direct;
        }
    }

    static int turn() {
        boolean check = true;
        int cnt = 0;
        while (true) {
            cnt++;
            if (cnt > 1000)
                break;

            for (int k = 1; k <= K; k++) {
                Piece piece = pieces[k];
                int r = piece.r;
                int c = piece.c;
                if (pieceList[r][c] != null ||pieceList[r][c].get(0) == k) {
                    int tmpR = r + deltas[piece.direct][0];
                    int tmpC = c + deltas[piece.direct][1];

                    if (tmpR <= 0 || tmpR > N || tmpC <= 0 || tmpC > N || board[tmpR][tmpC] == 2) {
                        piece.direct = toggle(piece.direct);
                        tmpR = r + deltas[piece.direct][0];
                        tmpC = c + deltas[piece.direct][1];
                    }

                    if (tmpR <= 0 || tmpR > N || tmpC <= 0 || tmpC > N || board[tmpR][tmpC] == 2) {
                        continue;
                    } else if (board[tmpR][tmpC] == 1) {
                        for (int index = pieceList[r][c].size() - 1; index >= 0; index--) {
                            int tmpPiece = pieceList[r][c].get(index);
                            pieceList[tmpR][tmpC].add(tmpPiece);
                            pieces[tmpPiece].r = tmpR;
                            pieces[tmpPiece].c = tmpC;
                        }
                        pieceList[r][c].clear();
                    } else {
                        for (int index = 0; index < pieceList[r][c].size() - 1; index++) {
                            int tmpPiece = pieceList[r][c].get(index);
                            pieceList[tmpR][tmpC].add(tmpPiece);
                            pieces[tmpPiece].r = tmpR;
                            pieces[tmpPiece].c = tmpC;
                        }
                        pieceList[r][c].clear();
                    }

                    if (pieceList[tmpR][tmpC].size() >= 4) {
                        check = false;
                        break;
                    }
                }
            }
        }
        return check ? -1 : cnt;
    }

    static int toggle(int direct) {
        switch (direct) {
            case 1:
                direct = 2;
                break;
            case 2:
                direct = 1;
                break;
            case 3:
                direct = 4;
                break;
            case 4:
                direct = 3;
                break;
        }
        return direct;
    }
}
