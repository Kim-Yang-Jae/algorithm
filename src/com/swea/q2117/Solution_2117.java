package com.swea.q2117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * SWEA Q2117 홈방범 서비스
 * 완전 탐색, 시뮬레이션
 */
public class Solution_2117 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(100); //객체 만드는 시간을 줄일 수 있음

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //도시 크기 5 <= N <= 20
            int M = Integer.parseInt(st.nextToken()); //가구당 지불 비용 1 <= M <= 10

            int[][] homes = new int[400][2];
            int size = 0;
            for (int r = 0; r < N; r++) {
                String s = br.readLine();
                for (int c = 0, index = 0; c < N; c++, index += 2) {
                    if(s.charAt(index) == '1'){
                        homes[size++] = new int[] {r,c};
                    }
                }
            }

            int maxCntHome = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    for (int K = 1; K <= 40; K++) {
                        int cntHome = 0;
                        for (int h = 0; h < size; h++) {
                            int distance = Math.abs(r - homes[h][0]) + Math.abs(c - homes[h][1]);
                            if(distance < K)
                                cntHome ++;
                        }
                        if (cntHome * M >= (K*K+(K-1)*(K-1))){
                            maxCntHome = Math.max(maxCntHome, cntHome);
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(maxCntHome).append("\n");
        }
        System.out.println(sb.toString());
    }
}
