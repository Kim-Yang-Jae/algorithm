package com.boj.bronze.q10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ Q10872 팩토리얼
 * 재귀함수
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(factorial(N));
        System.out.println(sb.toString());
        br.close();
    }// end of main method

    /**
     * N!을 구하는 재귀함수
     * @param N
     */
    static int factorial(int N) {
        if (N <= 1) //N이 1보다 작으면 1 리턴
            return 1;
        return N * factorial(N - 1);
    }// end of factorial method
}// end of Main class
