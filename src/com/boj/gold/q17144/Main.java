package com.boj.gold.q17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] room;
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Coordinate[] airCleaner;
    static Queue<Coordinate> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        room = new int[R][C];
        queue = new LinkedList<>();
        airCleaner = new Coordinate[2];

        int airCleanerCnt = 0;
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                room[r][c] = Integer.parseInt(st.nextToken());
                if (room[r][c] == -1) {
                    airCleaner[airCleanerCnt++] = new Coordinate(r, c, -1);
                }
            }
        }

        for (int time = 0; time < T; time++) {
            checkFineDust();
            spreadFineDust();
            airCycle();
        }

        int totalAmount = 2;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                totalAmount += room[r][c];
            }
        }
        System.out.println(totalAmount);
    }

    static class Coordinate {
        int row, col, amount;

        public Coordinate(int row, int col, int amount) {
            this.row = row;
            this.col = col;
            this.amount = amount;
        }
    }

    static void checkFineDust() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (room[r][c] >= 5)
                    queue.offer(new Coordinate(r, c, room[r][c]));
            }
        }
    }

    static void spreadFineDust() {
        while (!queue.isEmpty()) {
            int cnt = 0;
            Coordinate fineDust = queue.poll();
            for (int d = 0; d < 4; d++) {
                int tmpR = fineDust.row + deltas[d][0];
                int tmpC = fineDust.col + deltas[d][1];
                if (tmpR >= 0 && tmpR < R && tmpC >= 0 && tmpC < C && room[tmpR][tmpC] != -1) {
                    room[tmpR][tmpC] += fineDust.amount / 5;
                    cnt++;
                }
            }
            if (cnt != 0)
                room[fineDust.row][fineDust.col] -= (fineDust.amount / 5) * cnt;
        }
    }

    static void airCycle() {
        int upRow = airCleaner[0].row;
        int downRow = airCleaner[1].row;
        int col = 0;

        for (int r = upRow - 1; r > 0; r--) {
            room[r][col] = room[r - 1][col];
        }
        for (int c = 0; c < C - 1; c++) {
            room[0][c] = room[0][c + 1];
        }
        for (int r = 0; r < upRow; r++) {
            room[r][C - 1] = room[r + 1][C - 1];
        }
        for (int c = C - 1; c > 0; c--) {
            room[upRow][c] = room[upRow][c - 1];
        }
        room[upRow][col + 1] = 0;

        for (int r = downRow + 1; r < R - 1; r++) {
            room[r][col] = room[r + 1][col];
        }
        for (int c = 0; c < C - 1; c++) {
            room[R - 1][c] = room[R - 1][c + 1];
        }
        for (int r = R - 1; r > downRow; r--) {
            room[r][C - 1] = room[r - 1][C - 1];
        }
        for (int c = C - 1; c > 0; c--) {
            room[downRow][c] = room[downRow][c - 1];
        }
        room[downRow][col + 1] = 0;
    }
}
