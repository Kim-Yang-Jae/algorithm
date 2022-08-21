package com.boj.silver.q11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  BOJ Q11729 하노이 탑
 *  재귀 함수
 */
public class Main {
    static int N, count;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        getHanoiTowel(N, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb.toString());
    }// end of main method

    /**
     * 하노이의 탑 이동 횟수와 이동 순서 구하기
     * @param N 원판 개수
     * @param origin  출발지
     * @param waypoint  경유지
     * @param destination  목적지
     */
    static void getHanoiTowel(int N, int origin, int waypoint, int destination) {
        if (N == 1) { // 마지막 이동일 때
            sb.append(origin).append(" ").append(destination).append("\n");
            count++;
            return;
        }

        getHanoiTowel(N - 1, origin, destination, waypoint); //원판 한개를 1 -> 3으로 옮기기 위해 그 위의 원판 2로 옮기기
        sb.append(origin).append(" ").append(destination).append("\n");
        count++;
        getHanoiTowel(N - 1, waypoint, origin, destination); //2의 원판들을 다시 3으로 옮기기
    }// end of getHanoiTowel method
}// end of Main class
