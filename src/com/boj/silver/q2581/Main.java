package com.boj.silver.q2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ Q2581 소수
 * M이상 N이하인 자연수 중 소수인 수의 합과 최솟값 구하기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE, sum = 0, count = 0;
        for (int i = M; i <= N; i++) {
            if(isPrime(i)){
                count++;
                sum+=i;
                min = Math.min(i,min);
            }
        }
        if(count == 0)
            System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }// end of main method

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
