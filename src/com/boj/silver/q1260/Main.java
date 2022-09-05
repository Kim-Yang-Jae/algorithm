package com.boj.silver.q1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static int[][] adjMatrix;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjMatrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = 1;
            adjMatrix[to][from] = 1;
        }

        dfs(V);
        visited = new boolean[N + 1];
        System.out.println();
        bfs();
    }

    static void dfs(int V) {
        visited[V] = true;
        System.out.print(V + " ");
        for (int i = 1; i <= N; i++) {
            if(adjMatrix[V][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;
        System.out.print(V + " ");
        while (!queue.isEmpty()){
            int num = queue.poll();
            for (int i = 1; i <= N; i++) {
                if(adjMatrix[num][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
