package com.swea.q5643;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, cnt;
    static boolean[][] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            adjList = new boolean[N + 1][N + 1];
            int result = 0;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int current = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());
                adjList[current][next] = true;
            }

            for (int num = 1; num <= N; num++) {
                cnt = 0;
                bfs(num, "taller");
                bfs(num, "shorter");
                result = cnt == N - 1 ? result + 1 : result;
            }

            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int current, String condition) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(current);
        visited[current] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int check = 1; check <= N; check++) {
                boolean compare = false;
                if ("taller".equals(condition))
                    compare = adjList[num][check];
                else if ("shorter".equals(condition))
                    compare = adjList[check][num];

                if (!visited[check] && compare) {
                    queue.offer(check);
                    visited[check] = true;
                    cnt++;
                }
            }
        }
    }
}
