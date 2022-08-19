package com.boj.silver.q1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  BOJ Q1697 숨박꼭질
 *  BFS
 */
public class Main {
    static int N, K;
    static int[] check; //방문한 체크 및 방문한 시간 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new int[100_001];
        bfs(N);
        sb.append(check[K] -1); //처음 N점의 방문 순서를 1로해서 1을 빼줌
        System.out.println(sb.toString());
        br.close();
    }// end of main method

    /**
     * bfs를 통해 K점으로 가는 최단시간 구하는 메서드
     * @param point 탐색을 시작하는 점
     */
    static void bfs(int point) {
        Queue<Integer> queue = new LinkedList<>(); //Queue를 통해 bfs 구현
        queue.offer(point); //시작 점을 queue에 넣음
        int num = 0; //
        check[point] = 1; // 시작점 방문 순서 표시
        while (!queue.isEmpty()){ //큐가 모두 빌때까지 수행
            num = queue.poll(); //큐에서 숫자 꺼내기
            if(num == K) //큐에서 꺼낸 숫자가 K면 메서드 종료
                return;
            if(num - 1 >= 0 && check[num-1] == 0){ //num -1이 배열을 벗어나지 않고, 방문하지 않았으면
                queue.offer(num-1); //큐에 넣고
                check[num-1] = check[num] + 1; //방문 순서 표시
            }
            if(num + 1 < check.length && check[num + 1] == 0 ){ //num+1이 배열을 벗어나지 않고 방문하지 않았으면
                queue.offer(num+1); //큐에 넣고
                check[num+1] = check[num] + 1; //방문 순서 표시
            }
            if(num * 2 < check.length && check[num * 2]  == 0){ //num *2가 배열을 벗어나지 않고 방문하지 않았으면
                queue.offer(num*2); // 큐에 넣고
                check[num*2] = check[num] + 1; //방문 순서 표시
            }
        }
    }// end of bfs method
}// end of Main class
