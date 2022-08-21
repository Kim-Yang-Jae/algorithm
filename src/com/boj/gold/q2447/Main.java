package com.boj.gold.q2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  BOJ Q2447 별 찍기
 *  재귀함수, 분할정복
 */
public class Main {
    static int N;
    static char[][] stars; //별을 저장하여 출력할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stars = new char[N][N];

        partition(0,0,N,false);
        printStars();
        br.close();
    }// end of main method

    /**
     * 별을 찍을 공간을 1/3하여 조건에 맞는 구역에 별을 찍는 메서드
     * @param row
     * @param col
     * @param size
     * @param blank
     */
    public static void partition(int row, int col, int size, boolean blank) {
        if(blank){ //빈칸이 찍힐 구역이면 배열에 빈칸 찍기
            for (int r = row; r < row + size; r++) {
                for (int c = col; c < col + size; c++) {
                    stars[r][c] = ' ';
                }
            }
            return;
        }

        if(size == 1){ //크기가 1이되고 빈칸 구역이 아니면 별찍기
            stars[row][col] = '*';
            return;
        }

        int oneThird = size / 3; //전체 구역을 3분의 1하기 위한 변수
        partition(row, col, oneThird, false);
        partition(row, col + oneThird, oneThird, false);
        partition(row, col + (oneThird * 2), oneThird, false);
        partition(row + oneThird, col, oneThird, false);
        partition(row + oneThird, col + oneThird, oneThird, true); //이 구역은 항상 빈칸이 오는 구역
        partition(row + oneThird, col + (oneThird * 2), oneThird, false);
        partition(row + (oneThird * 2), col, oneThird, false);
        partition(row + (oneThird * 2), col + oneThird, oneThird, false);
        partition(row + (oneThird * 2), col + (oneThird * 2), oneThird, false);
    }// end of partition method

    /**
     * 별을 찍을 배열을 출력하는 메서드
     */
    static void printStars(){
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(stars[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }// end of printStars method
}// end of Main class
