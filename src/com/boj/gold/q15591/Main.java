package com.boj.gold.q15591;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] usado = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            usado[i] = new ArrayList<int[]>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            usado[p].add(new int[]{q, r});
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int result = 0;
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean visited[] = new boolean[N + 1];
            queue.offer(v);
            visited[v] = true;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int[] ints : usado[current]) {
                    int next = ints[0];
                    int weight = ints[1];
                    if (!visited[next] && weight >= k) {
                        result++;
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static class Node {
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
