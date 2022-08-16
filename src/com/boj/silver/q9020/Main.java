package com.boj.silver.q9020;

import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BOJ Q9020 골드바흐의 추측
 * 2보다 큰 모든 짝수는 두 소수의 합으로 표현 하는 것 ->  골드바흐 파티션
 * 주어진 숫자에 대한 골드바흐 파티션 출력
 * 단 골드바흐 파티션이 여러개인 경우 두 소수의 차이가 가장 작은것
 */
public class Main {
    static List<Integer> primeList;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        isNotPrime = new boolean[10001];

        primeList = new ArrayList<>();
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            getPrimeList(n);
            System.out.println(getGoldbachPartition(n));
        }

    }// end of main method

    static String getGoldbachPartition(int num) {
        StringBuilder sb = new StringBuilder();

        int minDifference = Integer.MAX_VALUE;
        int result1 = 0, result2 = 0;

        for (int prime : primeList) {
            int tmpNum = num - prime;
            if (primeList.contains(tmpNum)) {
                if (minDifference > Math.abs(tmpNum - prime)) {
                    minDifference = Math.abs(tmpNum - prime);
                    result1 = Math.min(prime, tmpNum);
                    result2 = Math.max(prime, tmpNum);
                }
            }
        }

        sb.append(result1).append(" ").append(result2);
        return sb.toString();
    }

    /**
     * 에라토스테네스의 체 메서드
     *
     * @param num 구하고자 하는 N
     */
    static void getPrimeList(int num) {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= num; i++) {
            if (!isNotPrime[i]) {
                primeList.add(i);
                for (int j = i + i; j <= num; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }// end of getPrimeList method
}// end of Main class
