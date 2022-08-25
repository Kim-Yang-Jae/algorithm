package com.boj.gold.q1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, K;
    static adjList adjLists;
    static int[] D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        adjLists = new adjList(V + 1);
        D = new int[V + 1];
        visited = new boolean[V + 1];

        for (int cnt = 0; cnt < E; cnt++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjLists.add(from, new Edge(to, weight));
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

    /**
     * 그래프를 저장한 인접리스트
     */
    static class adjList {
        private final LinkedList<LinkedList<Edge>> list = new LinkedList<>();

        //생성자 호출 시 인접리스트 초기화
        public adjList(int size) {
            for (int cnt = 0; cnt < size; cnt++) {
                list.add(new LinkedList<Edge>());
            }
        }

        //양방향성 그래프이므로 양쪽 노드 모두에 값 추가
        public void add(int from, Edge edge) {
            list.get(from).add(edge);
        }

        //해당 노드와 연결된 노드의 리스트 반환
        public LinkedList<Edge> get(int index) {
            return list.get(index);
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

            for (int i = 0; i < adjLists.get(end).size(); i++) {
                int end2 = adjLists.get(end).get(i).to;
                int weight2 = adjLists.get(end).get(i).weight;
                if(D[end2] > weight + weight2){
                    D[end2] = weight + weight2;
                    pQueue.offer(new Edge(end2, weight + weight2));
                }
            }
        }
    }
}
