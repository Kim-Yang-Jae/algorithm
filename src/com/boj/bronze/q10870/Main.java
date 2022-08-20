package com.boj.bronze.q10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ Q10870 피보나치수열 5
 * 재귀함수
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sb.append(getFibonacciNumber(n));

        System.out.println(sb.toString());
        br.close();
    }// end of main method

    /**
     * n 번째 피보나치 수열의 값을 구하는 메서드
     * @param n
     * @return
     */
    static int getFibonacciNumber(int n) {
        if(n<=1)
            return n;
        return getFibonacciNumber(n-1) + getFibonacciNumber(n-2);
    }// end of getFibonacciNumber method
}// end of Main class
