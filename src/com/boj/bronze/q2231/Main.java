package com.boj.bronze.q2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ Q2231 분해합
 * 완전 탐색
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        sb.append(getMinConstructor(N));
        System.out.println(sb.toString());
    }// end of main method

    /**
     * 가장 작은 생성자를 구하는 메서드
     * @param N
     * @return 가장 작은 생성자
     */
    static int getMinConstructor(int N) {
        int min = 0; //가장 작은 생성자를 저장하는 변수
        for (int i = 1; i < N; i++) { //1부터 분해합을 확인하여 N의 생성자인지 확인
            int sum = 0, tmpNum = i;
            while (tmpNum != 0) { //생성자 확인 시작
                sum += tmpNum % 10;
                tmpNum = tmpNum / 10;
            }
            sum += i; //생성자 확인 끝
            if (N == sum) {
                min = i;
                break;
            }
        }
        return min;
    }// end of getMinConstructor method
}// end of Main class
