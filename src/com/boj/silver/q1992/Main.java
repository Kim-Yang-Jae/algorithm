package com.boj.silver.q1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ Q1992 쿼드트리
 * 이미지가 모두 0이면 0으로 1이면 1로 압축
 * 섞여 있으면 4등분해서 압축(왼쪽 위 -> 오른쪽 위 -> 왼쪽 아래 -> 오른쪽 아래)
 */
public class Main {
    static int N;
    static char[][] vedio;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        vedio = new char[N][N];
        result = new StringBuilder();

        for (int row = 0; row < N; row++) {
            String input = br.readLine();
            for (int col = 0; col < N; col++) {
                vedio[row][col] = input.charAt(col);
            }
        }

        partition(0, 0, N);
        System.out.println(result.toString());

    }// end of main method

    /**
     * 비디오를 4등분으로 분할 하는 메서드
     * @param row
     * @param col
     * @param size
     */
    static void partition(int row, int col, int size) {
        if (check(row, col, size)) { //check 메서드를 통해 검수한 뒤 압축이 가능하면 압축하고 메서드 종료
            result.append(vedio[row][col]);
            return;
        }
        result.append("("); //영역의 시작괄호
        int half = size / 2; //비디오를 4등분하기 위해 크기를 1/2
        partition(row, col, half); //왼쪽 위
        partition(row, col + half, half); //오른쪽 위
        partition(row + half, col, half); //왼쪽 아래
        partition(row + half, col + half, half); //오른쪽 아래
        result.append(")");// 영역의 끝 괄호
    }// end of partition method

    /**
     * 비디오의 해당 구역에 대해서 압축이 가능한지 체크하는 메서드
     * @param row
     * @param col
     * @param size
     * @return 압축 가능 여부
     */
    static boolean check(int row, int col, int size) {
        int standard = vedio[row][col];//기준

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (standard != vedio[i][j]) //기준과 다른 값이 존재하면 압축 불가
                    return false;
            }
        }
        return true;
    }// end of check method
}// end of Main class
