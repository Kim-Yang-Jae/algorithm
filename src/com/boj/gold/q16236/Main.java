package com.boj.gold.q16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, totalCnt;
    static int[][] map;
    static int[][] deltas = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static Shark shark;
    static Queue<Coordinate> queue;
    static List<Coordinate> fishList;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        queue = new LinkedList<>();

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 9) {
                    shark = new Shark(r, c, 0, 2, 0);
                    queue.offer(shark);
                    map[r][c] = 0;
                }
            }
        }

        bfs();
        sb.append(totalCnt);
        System.out.println(sb.toString());
    }

    static class Coordinate implements Comparable<Coordinate> {
        int row, col, distance;

        public Coordinate(int row, int col, int distance) {
            super();
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.distance == o.distance) {
                if (this.row == o.row)
                    return this.col - o.col;
                return this.row - o.row;
            }
            return this.distance - o.distance;
        }
    }

    static class Shark extends Coordinate {
        int size, exp;

        public Shark(int row, int col, int distance, int size, int exp) {
            super(row, col, distance);
            this.size = size;
            this.exp = exp;
        }
    }

    static void bfs() {
        int cnt = 0;
        while (true) {
            fishList = new ArrayList<>();
            distance = new int[N][N];

            while (!queue.isEmpty()) {
                Coordinate coordinate = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int tmpR = coordinate.row + deltas[d][0];
                    int tmpC = coordinate.col + deltas[d][1];

                    if (tmpR >= 0 && tmpR < N && tmpC >= 0 && tmpC < N && distance[tmpR][tmpC] == 0 && map[tmpR][tmpC] <= shark.size) {
                        distance[tmpR][tmpC] = distance[coordinate.row][coordinate.col] + 1;
                        Coordinate next = new Coordinate(tmpR, tmpC, distance[tmpR][tmpC]);
                        queue.add(next);
                        if (map[tmpR][tmpC] > 0 && map[tmpR][tmpC] <= 6 && map[tmpR][tmpC] < shark.size)
                            fishList.add(next);
                    }
                }
            }
            if (fishList.size() == 0) {
                totalCnt = cnt;
                return;
            }

            cnt += eat();
        }
    }

    static int eat() {
        int cnt = 0;
        Collections.sort(fishList);
        Coordinate minDistanceFish = fishList.get(0);
        cnt = minDistanceFish.distance;
        shark.exp++;
        map[minDistanceFish.row][minDistanceFish.col] = 0;
        queue.add(new Coordinate(minDistanceFish.row, minDistanceFish.col, 0));
        if (shark.exp == shark.size) {
            shark.exp = 0;
            shark.size++;
        }
        return cnt;
    }
}
