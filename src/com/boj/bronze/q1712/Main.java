package com.boj.bronze.q1712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ Q1712 손익분기점
 * 고정 비용 : 생산 개수와 상관없는 비용
 * 가변 비용 : 생산 개수에 따라 달라지는 비용
 * 총 비용 : 고정 비용 + 가변 비용
 * 손익분기점 : 총 수입이 총 비용보다 커지는 지점
 */
public class Main {
    // A -> 고정 비용, B -> 가변 비용, C -> 제품가격
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(calcBreakEventPoint());
    }// end of main method

    /**
     * 고정 비용, 가변 비용, 제품 가격을 이용해 손익분기점 계산하는 메서드
     * @return 손익 분기점, 손익 분기점이 없다면 -1
     */
    static int calcBreakEventPoint() {
        //제품을 판매할수록 손해를 보므로 손익분기점 X
        if (B >= C)
            return -1;
        //제품가격에서 가변 비용을 빼 순이익 계산
        int netProfit = C - B;
        //고정 비용을 순이익으로 나눈 값에 1을 더해 손익분기점 계산
        int result = A / netProfit;
        return result + 1;
    }
}// end of Main class
