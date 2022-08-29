package com.boj.gold.q1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, K;
    static ArrayList<Edge>[] adjList;
    static int[] D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        adjList = new ArrayList[V + 1];
        D = new int[V + 1];
        visited = new boolean[V + 1];

        for(int i = 0; i < V+1 ; i++) {
            adjList[i] = new ArrayList<Edge>();
        }

        for (int cnt = 0; cnt < E; cnt++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from].add(new Edge(to, weight));
        }

        Arrays.fill(D, Integer.MAX_VALUE);
        D[K] = 0;

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (D[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(D[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

    static class Edge implements Comparable<Edge> {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static void dijkstra() {
        PriorityQueue<Edge> pQueue = new PriorityQueue<>();
        pQueue.offer(new Edge(K, 0));
        while (!pQueue.isEmpty()) {
            Edge edge = pQueue.poll();
            int end = edge.to;
            int weight = edge.weight;

            if (D[end] < weight)
                continue;

            for (int i = 0; i < adjList[end].size(); i++) {
                int end2 = adjList[end].get(i).to;
                int weight2 = adjList[end].get(i).weight;
                if (D[end2] > weight + weight2) {
                    D[end2] = weight + weight2;
                    pQueue.offer(new Edge(end2, weight + weight2));
                }
            }
        }
    }
}
