package com.boj.gold.q2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] map;
    static boolean[][] visited;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        getYearCnt();
    }

    static class Iceberg {
        int r, c;

        public Iceberg(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void getYearCnt() {
        int yearCnt = 0, numOfIceberg = 0, numOfIce = -1;

        while (true) {
            if (numOfIce == 0) {
                System.out.println(0);
                break;
            } else {
                numOfIceberg = getNumOfIceberg();
                if (numOfIceberg > 1) {
                    System.out.println(yearCnt);
                    break;
                }
            }

            meltIce();
            yearCnt++;

        }
    }

    static int getNumOfIceberg() {
        int cnt = 0;
        visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] != 0 && !visited[r][c]) {
                    dfs(r, c);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int tmpR = r + deltas[d][0];
            int tmpC = c + deltas[d][1];
            if (tmpR >= 0 && tmpR < R && tmpC >= 0 && tmpC < C && !visited[tmpR][tmpC] && map[tmpR][tmpC] != 0) {
                dfs(tmpR, tmpC);
            }
        }
    }

    static void meltIce(){
        visited = new boolean[R][C];
        Queue<Iceberg> queue = new LinkedList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if(map[r][c] != 0){
                    queue.offer(new Iceberg(r,c));
                    visited[r][c] = true;
                }
            }
        }
        bfs(queue);
    }

    static void bfs(Queue<Iceberg> queue) {
        while (!queue.isEmpty()) {
            Iceberg iceberg = queue.poll();
            int cnt = 0;
            int r = iceberg.r, c = iceberg.c;
            for (int d = 0; d < 4; d++) {
                int tmpR = r + deltas[d][0];
                int tmpC = c + deltas[d][1];

                if (tmpR >= 0 && tmpR < C && tmpC >= 0 && tmpC < R && !visited[tmpR][tmpC] && map[tmpR][tmpC] == 0) {
                    cnt ++;
                }
            }
            map[r][c] = map[r][c] < cnt ? 0 : map[r][c] - cnt;
        }
    }
}
