package com.boj.gold.q2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, time;
    static int[][] board;
    static int[][] deltas = {{1, 0}, {0, 1}};
    static boolean[][] visited;
    static List<Integer> cntList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        cntList = new ArrayList<>();

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int cnt = getCntOfCheese();

            if(cnt == 0)
                break;
            else
                cntList.add(cnt);

            time++;
            visited = new boolean[R][C];

            bfs(0, 0);
        }

        System.out.println(time);
        System.out.println(cntList.get(time - 1));
    }

    static class Coordinate {
        int r, c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs(int r, int c) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(r, c));

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            visited[coordinate.r][coordinate.c] = true;

            for (int d = 0; d < 2; d++) {
                int nr = coordinate.r + deltas[d][0];
                int nc = coordinate.c + deltas[d][1];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                    continue;

                if (!visited[nr][nc]) {
                    if (board[coordinate.r][coordinate.c] == 0 && board[nr][nc] == 1) {
                        board[nr][nc] = -1;
                        queue.offer(new Coordinate(nr, nc));
                    } else if (board[coordinate.r][coordinate.c] == 1 && board[nr][nc] == 0) {
                        board[coordinate.r][coordinate.c] = -1;
                        queue.offer(new Coordinate(nr, nc));
                    }else{
                        queue.offer(new Coordinate(nr, nc));
                    }
                }
            }
        }
    }

    static int getCntOfCheese() {
        int cnt = 0;
        for (int r = 1; r < R - 1; r++) {
            for (int c = 1; c < C - 1; c++) {
                if(board[r][c] == 1)
                    cnt++;
                else if(board[r][c] == -1)
                    board[r][c] = 0;
            }
        }
        return cnt;
    }
}
