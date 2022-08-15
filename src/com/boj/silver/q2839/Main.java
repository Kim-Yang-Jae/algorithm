package com.boj.silver.q2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  BOJ Q2839 설탕 배달
 *  3kg, 5kg 설탕 봉지
 *  Nkg 설탕 배달 할때 가장 적은 봉지 수 출력
 */
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        System.out.println(calcMinNumOfBag());
    }// end of main method

    /**
     * 최소 설탕 봉지 개수를 구하는 메서드
     * @return 최소 설탕 봉지 개수
     */
    static int calcMinNumOfBag(){
        int fiveNum = 0, count = Integer.MAX_VALUE;
        while(5*fiveNum <= N){ //5kg 봉지의 개수를 늘려가며 최솟값 비교
            int tmpN = N;
            tmpN = tmpN  - (5 * fiveNum);
            if(tmpN % 3 == 0) //나누어 떨어질 때만 최솟값 비교
                count = Math.min(count, fiveNum + (tmpN / 3));
            fiveNum++;
        }
        if (count == Integer.MAX_VALUE) // 정확하게 Nkg이 아니기 때문에 -1 리턴
            count = -1;
        return count;
    }// end og calcMinNumOfBag method
}// end of Main class
