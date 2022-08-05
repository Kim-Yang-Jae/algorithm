package com.boj.bronze.q1260;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] adjMatrix;
    public static boolean[] checkArr;
    public static int N;
    public static int M;
    public static int V;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjMatrix = new int[N + 1][N + 1];
        checkArr = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            adjMatrix[row][col] = 1;
            adjMatrix[col][row] = 1;
        }

        dfs(V);
        checkArr = new boolean[N+1];
        System.out.println();
        bfs();

    }

    public static void dfs(int V) {
        checkArr[V] = true;

        System.out.print(V + " ");
        for (int i = 1; i <= N; i++) {
            if (adjMatrix[V][i] == 1 && checkArr[i] == false)
                dfs(i);
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(V);
        checkArr[V] = true;
        System.out.print(V + " ");

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            for (int i = 1; i <= N; i++) {
                if(adjMatrix[tmp][i] == 1 && checkArr[i] == false){
                    queue.offer(i);
                    checkArr[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
