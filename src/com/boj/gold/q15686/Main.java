package com.boj.gold.q15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ Q15686 치킨 배달
 * N*N 도시 
 * 치킨거리 : 집과 가장 가까운 치킨집 사이 거리 
 * 도시의 치킨거리 : 모든 집의 치킨 거리의 합
 * (r1, c1) (r2,c2) 사이 거리 = |r1-r2|+ |c1-c2| 
 * 0 -> 빈칸, 1 -> 집, 2 -> 치킨집 
 * M개의 치킨집만 남을 때 도시의 치킨거리가 가장 적은 경우
 */
public class Main {
    static int N, M, chickenCnt, houseCnt, minDistance;
    static int[][] chicken;
    static int[][] houses;
    static int[][] selected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new int[14][2];
        houses = new int[2 * N + 1][3];
        selected = new int[M][2];
        chickenCnt = 0;
        houseCnt = 0;
        minDistance = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int place = Integer.parseInt(st.nextToken());
                if (place == 2) {
                    chicken[chickenCnt++] = new int[] { i, j };
                } else if (place == 1) {
                    houses[houseCnt][0] = i;
                    houses[houseCnt][1] = j;
                    houses[houseCnt][2] = Integer.MAX_VALUE;
                    houseCnt++;
                }
            }
        }

        comb(0, 0);
        sb.append(minDistance);
        System.out.println(sb.toString());
        br.close();
    }// end of main method

    /**
     * 폐업 시키지 않을 치킨집을 뽑아 가장 작은 도시의 치킨 거리 구하는 메서드
     * @param cnt
     * @param index
     */
    static void comb(int cnt, int index) {
        int sum = 0;
        if (cnt == M) {
            sum = calcChickenDistance(selected);
            minDistance = Math.min(minDistance, sum);
            return;
        }
        if (index >= chickenCnt) {
            sum = calcChickenDistance(selected);
            minDistance = Math.min(minDistance, sum);
            return;
        }
        selected[cnt] = chicken[index];
        comb(cnt + 1, index + 1);
        comb(cnt, index + 1);
    }// end of comb

    /**
     * 도시의 치킨거리 구하는 메서드
     * @param arr
     * @return 도시의 치킨거리
     */
    static int calcChickenDistance(int[][] arr) {
        int totalSum = 0;
        for (int[] ints : arr) {
            for (int i = 0; i < houseCnt; i++) {
                int distance = calcDistance(ints, new int[] { houses[i][0], houses[i][1] });
                houses[i][2] = Math.min(houses[i][2], distance);
            }
        }

        for (int i = 0; i < houseCnt; i++) {
            totalSum += houses[i][2];
            houses[i][2] = Integer.MAX_VALUE;
        }

        return totalSum;
    }// end of calcChickenDistance

    /**
     * 두점의 거리 구하는 메서드
     * @param p1
     * @param p2
     * @return 두점의 거리
     */
    static int calcDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }// end of calcDistance method
}// end of class
