package com.boj.silver.q9020;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BOJ Q9020 골드바흐의 추측 2보다 큰 모든 짝수는 두 소수의 합으로 표현 하는 것 -> 골드바흐 파티션 주어진 숫자에 대한 골드바흐
 * 파티션 출력 단 골드바흐 파티션이 여러개인 경우 두 소수의 차이가 가장 작은것
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(getGoldbachPartition(n));
        }

    }// end of main method

    /**
     * 차가 가장 작은 골드바흐 파티션 구하는 메서드
     *
     * @param num 주어진 숫자
     * @return 골드바흐 파티션
     */
    static String getGoldbachPartition(int num) {
        StringBuilder sb = new StringBuilder();

        int minDifference = Integer.MAX_VALUE;
        int result1 = 0, result2 = 0;

        for (int i = 1; i < num; i++) {
            if (isPrime(i)) {
                int tmpNum = num - i;
                if (isPrime(tmpNum)) {
                    if (minDifference > Math.abs(tmpNum - i)) {
                        minDifference = Math.abs(tmpNum - i);
                        result1 = Math.min(i, tmpNum);
                        result2 = Math.max(i, tmpNum);
                    }
                }
            }
        }

        sb.append(result1).append(" ").append(result2);
        return sb.toString();
    }// end of getGoldbachPartition method

    /**
     * 소수 판별 메서드
     *
     * @param num 판별하려는 수
     * @return 소수 여부
     */
    static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }// end of isPrime method
}// end of Main class
