package com.boj.bronze.q1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ Q1193 분수찾기
 * 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> ...
 * X번째 분수
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        printNthFraction(X);
    }// end of main method

    static void printNthFraction(int X){
        StringBuilder sb = new StringBuilder();
        int count = 1; //X가 속해있는 대각선이 몇번째 대각선인지
        int num = 1; //X가 속해있는 대각선에서 가장 마지막 번호

        //X가 몇번째 대각선에 속해있는지 구함.
        while (num < X) {
            count++;
            num += count;
        }
        //분모 분자 변수 초기화
        int denominator = 0, numerator = 0;
        //X가 1이면 1/1 출력
        if (X == 1) {
            denominator = 1;
            numerator = 1;
        } else if (count % 2 == 0) { //count가 짝수면 해당 대각선의 가장 마지막 수는 count/1
            numerator = count;
            denominator = 1;
            for (int i = num; i > X; i--) { // 마지막 번호부터 X번째까지 분모 분자 조절
                numerator--;
                denominator++;
            }
        } else { //count가 홀수면 해당 대각선의 가장 마지막 수는 1/count
            numerator = 1;
            denominator = count;
            for (int i = num; i > X; i--) { // 마지막 번호부터 X번째까지 분모 분자 조절
                numerator++;
                denominator--;
            }
        }
        sb.append(numerator).append("/").append(denominator);
        System.out.println(sb.toString());
    }// end of printNthFraction method;
}// end of Main class
