package com.boj.gold.q17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        numArr = new int[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        getNGE();
    }

    static void getNGE() {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && numArr[stack.peek()] < numArr[i]){
                numArr[stack.pop()] = numArr[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            numArr[stack.pop()] = -1;
        }
        for (int i = 0; i < N; i++) {
            sb.append(numArr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
