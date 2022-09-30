package com.swea.q1249;

import java.io.*;
import java.util.PriorityQueue;

public class Solution {
    static int N, minTime;
    static int[][] map;
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            minTime = Integer.MAX_VALUE;
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < N; c++) {
                    map[r][c] = str.charAt(c) - '0';
                }
            }
            bfs(0, 0);

            bw.write("#" + tc + " " + minTime + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Coordinate implements Comparable<Coordinate> {
        int r, c, time;

        public Coordinate(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

        @Override
        public int compareTo(Coordinate o) {
            return Integer.compare(this.time, o.time);
        }
    }

    static void bfs(int r, int c) {
        PriorityQueue<Coordinate> pQueue = new PriorityQueue<>();
        visited[r][c] = true;
        pQueue.offer(new Coordinate(r, c, 0));

        while (!pQueue.isEmpty()) {
            Coordinate coordinate = pQueue.poll();

            int row = coordinate.r;
            int col = coordinate.c;
            int time = coordinate.time;

            if (row == N - 1 && col == N - 1) {
                minTime = Math.min(minTime, time);
            }

            for (int d = 0; d < 4; d++) {
                int nr = row + deltas[d][0];
                int nc = col + deltas[d][1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    int nt = time + map[nr][nc];
                    visited[nr][nc] = true;
                    pQueue.offer(new Coordinate(nr, nc, nt));
                }
            }
        }
    }
}
