package com.boj.silver.q4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  BOJ Q4948 베르트랑 공준
 *  n보다 크고 2n보다 작거나 같은 소수 개수
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = -1;
        while ((num = Integer.parseInt(br.readLine())) != 0){
            System.out.println(getCntOfPrime(num));
        }
    }// end of main method

    /**
     * num 보다 크고 2*num 보다 작은 소수 개수 구하는 메서드
     * @param num 범위를 위한 숫자
     * @return 소수의 개수
     */
    static int getCntOfPrime(int num){
        int count = 0;
        for (int i = num + 1; i <= num * 2; i++) {
            if(isPrime(i))
                count++;
        }
        return count;
    }// end of getCntOfPrime method

    /**
     * 소수 판별 함수
     * @param num 소수 판별을 원하는 수
     * @return 소수 여부
     */
    static boolean isPrime(int num) {
        if(num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }// end of isPrime method
}// end of Main class
