package com.boj.silver.q1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ Q1074 Z
 * 2^N * 2^N 배열을 2^(N-1) * 2^(N-1) 배열로 4등분
 * 4등분 한 배열의 왼쪽 위 -> 오른쪽 위 -> 왼쪽 아래 -> 오른쪽 아래 순으로 방문
 * r행 c열의 방문 순서 출력
 */
public class Main {
    static int N, r, c, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int length = (int) Math.pow(2, N);
        calcVisitOrder(0, 0, length);
        System.out.println(count);

    }// end of main method

    /**
     * (r,c)를 몇번째로 방문하는지 탐색하는 메서드
     * @param row
     * @param col
     * @param size
     */
    static void calcVisitOrder(int row, int col, int size) {
        if (size == 1) { //(r,c) 한칸만 남을 때 메서드 종료
            return;
        }
        int half = size / 2; //2차원 배열을 4등분하기 위한 크기
        if (r < row + half) { //r과 c값을 이용해 (r,c)의 위치 확인
            if (c < col + half) {//처음부터 방문하기 때문에 count도 처음부터
                count += 0;
                calcVisitOrder(row, col, half);
            } else {//이미 (size/2)*(size/2)의 배열을 탐색한 뒤이기 때문에 count도 half*half 부터
                count += half * half;
                calcVisitOrder(row, col + half, half);
            }
        } else {
            if (c < col + half) {//이미 (size/2)*(size/2)의 배열을 2개 탐색한 뒤이기 때문에 count도 half*half*2 부터
                count += half * half * 2;
                calcVisitOrder(row + half, col, half);
            } else {//이미 (size/2)*(size/2)의 배열을 3개 탐색한 뒤이기 때문에 count도 half*half*3 부터
                count += half * half * 3;
                calcVisitOrder(row + half, col + half, half);
            }
        }
    }// end of calcVisitOrder method
}// end of Main class
