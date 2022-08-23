package com.boj.gold.q13023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *  BOJ Q13023 ABCDE
 *  DFS, 백트래킹
 */
public class Main {
    static adjList adjLists; //그래프를 저장할 인접리스트
    static boolean[] visited; // 방문 여부 확인
    static int N, M, maxDepth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //그래프 노드 개수
        M = Integer.parseInt(st.nextToken()); //그래프 간선 개수
        adjLists = new adjList(N);

        for (int cnt = 0; cnt < M; cnt++) { //그래프를 인접리스트에 저장
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjLists.add(from, to);
        }

        int result = 0; //결과를 저장할 변수
        for (int i = 0; i < N; i++) { //시작노드를 다르게 해서 가장 큰값 찾기
            visited = new boolean[N]; //방문 배열 초기화
            if(dfs(i, 1)) { //
                result = 1;
                break;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 그래프를 저장한 인접리스트
     */
    static class adjList {
        private LinkedList<LinkedList<Integer>> list = new LinkedList<>();

        //생성자 호출 시 인접리스트 초기화
        public adjList(int size) {
            for (int cnt = 0; cnt < size; cnt++) {
                list.add(new LinkedList<Integer>());
            }
        }

        //양방향성 그래프이므로 양쪽 노드 모두에 값 추가
        public void add(int from, int to) {
            list.get(from).add(to);
            list.get(to).add(from);
        }

        //해당 노드와 연결된 노드의 리스트 반환
        public LinkedList<Integer> get(int index) {
            return list.get(index);
        }
    }

    /**
     * dfs 탐색하여 maxdepth가 5이상이면 true 아니면 false
     * @param node 현재 방문한 노드
     * @param cnt depth를 세기 위한 변수
     * @return
     */
    static boolean dfs(int node, int cnt) {
        visited[node] = true; //방문 표시
        maxDepth = Math.max(cnt, maxDepth); //depth 비교
        if(maxDepth == 5) // depth의 최댓값이 5가 되면 true 반환
            return true;
        for (int num : adjLists.get(node)) { //현재 노드의 인접노드 모두 확인
            if (visited[num] == false) //다음 노드가 방문하지 않았다면 다음 노드로 이동
                dfs(num, cnt + 1);
        }
        visited[node] = false; //방문 표시를 해제하여 해당 그래프에서 가장 큰 depth 찾기
        return false; //모두 돌았는데 depth 최댓값이 5보다 작으면  false 반환
    }
}

