package com.boj.silver.q9205;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Coordinate start, end;
    static Coordinate[] cvs;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            cvs = new Coordinate[n];
            visited = new boolean[n];
            int index = 0;

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (i == 0)
                    start = new Coordinate(r, c);
                else if (i == n + 1)
                    end = new Coordinate(r, c);
                else
                    cvs[index++] = new Coordinate(r, c);
            }

            String result = bfs() ? "happy" : "sad";
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Coordinate {
        int r, c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean bfs() {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            int r = coordinate.r;
            int c = coordinate.c;

            if (getDistance(coordinate, end) <= 1000)
                return true;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    if (getDistance(coordinate, cvs[i]) <= 1000) {
                        queue.offer(cvs[i]);
                        visited[i] = true;
                    }
                }
            }
        }
        return false;
    }

    static int getDistance(Coordinate c1, Coordinate c2) {
        return Math.abs(c1.r - c2.r) + Math.abs(c1.c - c2.c);
    }
}
