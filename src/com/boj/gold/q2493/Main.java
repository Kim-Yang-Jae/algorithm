package com.boj.gold.q2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Tower> towers;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        towers = new Stack<>();
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            findReceptionTower(i + 1, height);
        }

        System.out.println(sb.toString());
    }

    static class Tower {
        int num, height;

        public Tower(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }

    static void findReceptionTower(int index, int height) {
        if (towers.isEmpty()) {
            sb.append(0).append(" ");
            towers.push(new Tower(index, height));
            return;
        }
        while (true) {
            if (towers.isEmpty()) {
                sb.append(0).append(" ");
                towers.push(new Tower(index, height));
                break;
            }
            Tower top = towers.peek();

            if (top.height > height) {
                sb.append(top.num).append(" ");
                towers.push(new Tower(index, height));
                break;
            }
            towers.pop();
        }
    }
}
