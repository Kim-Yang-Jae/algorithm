package com.boj.gold.q1194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, minCnt;
    static char[][] map;
    static Coordinate start;
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minCnt = Integer.MAX_VALUE;
        map = new char[N][M];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] == '0') {
                    start = new Coordinate(r, c, 0, 0);
                }
            }
        }

        bfs(start.r, start.c);

        System.out.println(minCnt == Integer.MAX_VALUE ? -1 : minCnt);

    }

    static class Coordinate {
        int r, c, cnt, key;

        public Coordinate(int r, int c, int cnt, int key) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.key = key;
        }
    }

    static void bfs(int r, int c) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(r, c,0, 0));
        boolean[][][] visited = new boolean[N][M][1 << 6];
        visited[r][c][0] = true;

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = coordinate.r + deltas[d][0];
                int nc = coordinate.c + deltas[d][1];
                int key = coordinate.key;
                int cnt = coordinate.cnt;

                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if (map[nr][nc] == '1') {
                    minCnt = Math.min(cnt + 1, minCnt);
                    return;
                } else if(!visited[nr][nc][key]){
                    if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
                        int copy = key;
                        copy |= (1 << (map[nr][nc] - 'a'));
                        visited[nr][nc][copy] = true;
                        queue.offer(new Coordinate(nr, nc, cnt + 1, copy));
                    } else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
                        if(!((key & (1 << (map[nr][nc] - 'A'))) == 0)){
                            visited[nr][nc][key] = true;
                            queue.offer(new Coordinate(nr, nc, cnt + 1, key));
                        }
                    } else if (map[nr][nc] != '#') {
                        visited[nr][nc][key] = true;
                        queue.offer(new Coordinate(nr, nc, cnt + 1, key));
                    }
                }
            }
        }
    }
}

