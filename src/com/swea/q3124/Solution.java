package com.swea.q3124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA Q3124 최소 스패닝 트리
 *  최소 신장 트리 - kruskal 알고리즘
 */
public class Solution {
    static int[] parents; //정점을 저장할 배열
    static int V, E; //정점 개수, 간선 개수
    static Edge[] edgeList; //간선을 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edgeList = new Edge[E];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
            }
            make(); //사이클 여부를 검사하기 위한 정점 배열 생성
            Arrays.sort(edgeList); //가중치에 따라 간선 배열 정렬

            long result = 0; //결과값을 위한 변수
            int count = 0; //최소 스패닝 트리는 사용한 간선의 수가 정점의 개수 - 1개
            for (Edge edge : edgeList) {
                if (union(edge.from, edge.to)) { //간선을 하나씩 꺼내서 사이클 여부 검색
                    result += edge.weight; //사이클이 아니면 가중치 더해주기
                    if (++count == V - 1) //사용한 간선의 수가 정점의 개수 - 1개이면 for문 종료
                        break;
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    /**
     * 간선의 정보를 저장하기 위한 클래스
     */
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {

            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        //가중치를 기준으로 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    /**
     *  정점수에 맞게 배열 생성
     */
    static void make() {
        parents = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }

    /**
     * 해당 정점의 대표값을 반환해주는 메서드, a가 어떤 집합에 속해있는지 찾는 메서드
     * @param a
     * @return
     */
    static int find(int a) {
        if (parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);
    }

    /**
     * a가 속한 집합과 b가 속한 집합을 비교해 두집합이 사이클이 아니면 합하고 return true, 사이클이면 false
     * @param a
     * @param b
     * @return
     */
    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot)
            return false;

        parents[bRoot] = aRoot;
        return true;
    }
}