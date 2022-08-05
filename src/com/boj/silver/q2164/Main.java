package com.boj.silver.q2164;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> shuffle = new LinkedList<Integer>();

        for (int i = 0; i < N; i++) {
            shuffle.offer(i+1);
        }
        while(shuffle.size() != 1){
            shuffle.poll();
            int tmp = shuffle.poll();
            shuffle.offer(tmp);
        }
        bw.write(""+shuffle.poll()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
