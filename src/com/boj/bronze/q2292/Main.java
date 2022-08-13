package com.boj.bronze.q2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ Q2292 벌집
 * 육각형의 벌집은 중앙의 1번 방부터 방주위를 감싸가면서 1씩 증가하는 모양
 * 1번방에서 N번방 까지 갈 때 지나는 최소 개수 방
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = 1; //지나는 최소 개수의 방이 cnt 가 되는 가장 큰 번호의 방
        int cnt = 1; //num 까지 가지위해 지나는 최소 개수의 방
        while (num < N) { //num이 N보다 커지는 순간 N번 방으로 가기 위한 최소 개수의 방은 cnt개
            num += cnt * 6; //num이 N보다 작을 때 지나는 최소 개수의 방이 하나 늘어났을 때의 가장 큰 번호 방을 구하는 공식
            cnt++; //지나는 최소 개수의 방 하나 늘리기
        }
        System.out.println(cnt);
    }// end of main method
}// end of Main class
