package com.boj.silver.q1158;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> circle;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        circle = new LinkedList<>();
        printJosephusSequence(N, K);

    }

    public static void printJosephusSequence(int N, int K) {
        for (int i = 1; i <= N; i++) {
            circle.offer(i);
        }
        System.out.print("<");
        int cnt = 0;
        while (!circle.isEmpty()) {
            int num = circle.poll();
            cnt++;
            if (circle.size() == 0) {
                System.out.printf("%d>", num);
            } else if (cnt == K) {
                cnt = 0;
                System.out.printf("%d, ", num);
            } else {
                circle.offer(num);
            }
        }
    }
}
