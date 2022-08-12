package com.boj.silver.q11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * BOJ Q11286 절대값 힙
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                int i = Math.abs(o1) - Math.abs(o2);
                if (Math.abs(o1) > Math.abs(o2))
                    return i;
                else if (Math.abs(o1) == Math.abs(o2))
                    return o1 > o2 ? 1 : -1;
                else
                    return i;
            }
        });

        for(int i =0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(queue.isEmpty()) {
                    sb.append("0").append("\n");
                }else {
                    sb.append(queue.poll()).append("\n");
                }
            }else {
                queue.offer(input);
            }
        }
        System.out.println(sb.toString());

    }// end of main method
}// end of class
