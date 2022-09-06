package com.boj.gold.q5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static int[] visited;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new int[F + 1];
        queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = 1;
        bfs();
    }

    static void bfs(){
        while (!queue.isEmpty()){
            int floor = queue.poll();
            if(floor == G){
                System.out.println(visited[floor] - 1);
                break;
            }
            if(floor + U <= F && visited[floor+U] == 0){
                queue.offer(floor+U);
                visited[floor+U] = visited[floor] + 1;
            }
            if(floor - D > 0 && visited[floor-D] == 0){
                queue.offer(floor-D);
                visited[floor-D] = visited[floor] + 1;
            }
        }
        if(visited[G] == 0)
            System.out.println("use the stairs");
    }
}
