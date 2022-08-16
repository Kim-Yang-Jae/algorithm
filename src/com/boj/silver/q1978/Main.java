package com.boj.silver.q1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ Q1978 소수 찾기
 * 주어진 수 N개 중 소수 개수
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(isPrime(num))
                count++;
        }
        System.out.println(count);
    }// end of main method

    /**
     * 소수 판별 메서드
     * @param num 소수인지 확인하고 하는 숫자
     * @return 소수 여부
     */
    static boolean isPrime(int num) {
        //num이 0,1이면 false
        if (num < 2)
            return false;
        //num의 약수가 있으면 false
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}// end of Main class
