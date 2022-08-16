package com.boj.silver.q1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ Q1929 소수
 * M이상 N이하인 자연수 중 소수 모두 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        printPrime(M, N);
    }// end of main method

    /**
     * M~N 사이의 소수 출력 메서드
     * @param M
     * @param N
     */
    static void printPrime(int M, int N) {
        for (int i = M; i <= N; i++) {
            if (isPrime(i))
                System.out.println(i);
        }
    }// end of printPrime method

    /**
     * 소수 판별 함수
     * @param num 소수 판별을 원하는 수
     * @return 소수 여부
     */
    static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if(num%i==0)
                return false;
        }
        return true;
    }// end of isPrime method
}// end of Main class
