package com.boj.gold.q7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H, dayCnt;
    static int[][][] box;
    static int[][] deltas = {{-1, 0, 0}, {1, 0, 0}, {0, 0, -1}, {0, 0, 1}, {0, 1, 0}, {0, -1, 0}};
    static Queue<Tomato> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        queue = new LinkedList<>();

        for (int d = 0; d < H; d++) {
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    box[d][r][c] = Integer.parseInt(st.nextToken());
                    if (box[d][r][c] == 1)
                        queue.offer(new Tomato(d, r, c, 0));
                }
            }
        }
        bfs();
        System.out.println(dayCnt);
    }

    static class Tomato {
        int depth, row, col, cnt;

        public Tomato(int depth, int row, int col, int cnt) {
            this.depth = depth;
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    static void bfs() {
        Tomato tomato = null;
        while (!queue.isEmpty()) {
            tomato = queue.poll();
            for (int i = 0; i < 6; i++) {
                int depth = tomato.depth + deltas[i][0];
                int row = tomato.row + deltas[i][1];
                int col = tomato.col + deltas[i][2];
                if (depth >= 0 && depth < H && row >= 0 && row < N && col >= 0 && col < M && box[depth][row][col] == 0) {
                    box[depth][row][col] = 1;
                    queue.offer(new Tomato(depth, row, col, tomato.cnt + 1));
                }
            }
        }
        if(check())
            dayCnt = tomato.cnt;
        else
            dayCnt = -1;
    }

    static boolean check(){
        boolean isCheck = true;
        Loop:
        for (int d = 0; d < H; d++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if(box[d][r][c] == 0) {
                        isCheck = false;
                        return isCheck;
                    }
                }
            }
        }
        return isCheck;
    }
}
