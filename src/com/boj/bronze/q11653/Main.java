package com.boj.bronze.q11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * BOJ Q11653 소인수분해
 * 정수 N 소인수분해
 */
public class Main {
    static List<Integer> primeList;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        primeList = new ArrayList<>();
        isNotPrime = new boolean[N + 1];
        getPrimeList(N);
        printFactorization(N);

    }// end of main method

    /**
     * 소인수 분해 재귀 메서드
     * @param N 소인수 분해 하는 수
     */
    static void printFactorization(int N) {
        //재귀함수 중 N이 1이되면 탈출
        if (N == 1)
            return;
        //N보다 작은 소수 중에서 하나를 뽑아 나누기
        for (int num : primeList) {
            if (N % num == 0) {
                N = N / num;
                System.out.println(num);
                printFactorization(N);
                break;
            }

        }
    }// end of printFactorization method

    /**
     * 에라토스테네스의 체 메서드
     * @param N 구하고자 하는 N
     */
    static void getPrimeList(int N) {
        //0과 1은 소수가 아님
        isNotPrime[0] = isNotPrime[1] = true;
        //N보다 작은 수 확인
        for (int i = 2; i <= N; i++) {
            if (!isNotPrime[i]) { //isNotPrime[i]가 false면 i는 소수
                primeList.add(i);
                for (int j = i + i; j <= N; j += i) { //i의 배수는 소수 아님
                    isNotPrime[j] = true;
                }
            }
        }
    }// end of getPrimeList method
}// end of Main class
