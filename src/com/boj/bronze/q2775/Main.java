package com.boj.bronze.q2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  BOJ Q2775 부녀회장이 될테야
 *  a층 b호에 살려면 (a-1)층 b호 까지 사람들의 수의 합만큼 거주자 필요
 *  0층 부터 있고 각층 1호부터 시작
 *  0층 i호는 i명 거주
 */
public class Main {
    static int k, n;
    static int[][] apartments;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            apartments = new int[k+1][n+1];
            sb.append(calcNumOfResidents()).append("\n");
        }
        System.out.println(sb.toString());
    }// end of main method

    /**
     * k층 n호에 거주하는 거주인 수를 구하는 메서드
     * @return k층 n호에 거주하는 거주인 수
     */
    static int calcNumOfResidents(){
        for (int row = 0; row <= k; row++) {
            for (int col = 1; col <=n ; col++) {
                if(row == 0){ //0층 i호는 i명 거주
                    apartments[row][col] = col;
                    continue;
                }
                for (int i = 1; i <= col; i++) { // row층 col호는 row-1층의 1호부터 col호까지 거주인 수 합 거주
                    apartments[row][col] += apartments[row-1][i];
                }
            }
        }
        return apartments[k][n];
    }// end of calcNumOfResidents method
}// end of Main class
