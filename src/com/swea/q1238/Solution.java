package com.swea.q1238;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  SWEA BOQ1238 Contact
 *  BFS
 */
public class Solution {
    static int length, startPoint, size, max, maxDepth;
    static int[][] adjMatrix;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            length = Integer.parseInt(st.nextToken()); //입력 데이터의 길이
            startPoint = Integer.parseInt(st.nextToken()); //시작점
            adjMatrix = new int[101][101]; //인접행렬
            depth = new int[101]; //레벨
            max = 0; //가장 깊은 레벨에서 가장 큰 값을 저장하기 위한 변수
            maxDepth = 0; //가장 깊은 레벨을 저장하기 위한 변수

            st = new StringTokenizer(br.readLine());
            for (int cnt = 0; cnt < length / 2; cnt++) { //2개씩 읽어오기때문에 1/2
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                adjMatrix[row][col] = 1;
                size = Math.max(size, row);
                size = Math.max(size, col);
            }

            bfs(startPoint);
            bw.write("#" + tc + " " + max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    /**
     * BFS를 통해 그래프를 탐색하는 메서드
     * @param node 시작점
     */
    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node); //시작점을 큐에 저장
        depth[node] = 1; //방문 표시 겸 방문한 노드의 레벨 저장
        while (!queue.isEmpty()) { //큐가 모두 빌때까지 수행
            int num = queue.poll(); //큐에서 노드를 꺼내 num에 대입
            for (int c = 0; c < size; c++) { //num과 인접한 노드 찾기
                if (adjMatrix[num][c] == 1 && depth[c] == 0) { //num과 인접하고 방문하지 않았으면
                    depth[c] = depth[num] + 1; //레벨 +1
                    queue.offer(c); //큐에 데이터 삽입

                }
            }
        }

        for (int d = 0; d < depth.length; d++) { //가장 깊은 레벨과 해당 레벨에서 가장 큰값 찾기
            if (maxDepth <= depth[d]) {
                maxDepth = depth[d];
                max = d;
            }
        }
    }
}
