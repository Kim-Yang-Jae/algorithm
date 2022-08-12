package com.swea.q4012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA Q4012 요리사
 * N개의 식재료를 각각 N/2개씩 사용하여 두가지 음식 요리
 * 두 음식의 맛의 차이가 최소가 되도록 재료 배분
 * 음식의 맛은 식재료들의 조합에 따른 시너지
 * 식재료 1 식재료 2의 시너지 값은 식재료 1과 식재료 2 시너지 + 식재료 2와 식재료 1시너지
 */
public class Solution {
    static int N, tasteOfFood, minDifference;
    static int[][] combTable;
    static boolean[] isGradientA;
    static int[] gradientsA;
    static int[] gradientsB;
    static int[] selected;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            combTable = new int[N + 1][N + 1];
            gradientsA = new int[N / 2];
            gradientsB = new int[N / 2];
            isGradientA = new boolean[N + 1];
            selected = new int[2];
            minDifference = Integer.MAX_VALUE;

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    combTable[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            chooseGradients(0, 0);
            sb.append("#").append(tc).append(" ").append(minDifference).append("\n");
        }
        System.out.println(sb.toString());
    }// end of main

    /**
     * 음식A와 음식B의 식재료를 각각 N/2씩 나누는 조합 메서드
     * @param cnt   뽑은 식재료 갯수
     * @param index 식재료를 뽑기위한 인덱스
     */
    static void chooseGradients(int cnt, int index) {
        if (cnt == N / 2) {
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (!isGradientA[i])
                    gradientsB[count++] = i;
            }
            calcTasteOfFood(gradientsA, 0, 0);
            int tasteA = Integer.valueOf(tasteOfFood);
            tasteOfFood = 0;
            calcTasteOfFood(gradientsB, 0, 0);
            int tasteB = Integer.valueOf(tasteOfFood);
            tasteOfFood = 0;
            minDifference = Math.min(minDifference, Math.abs(tasteA - tasteB));
            return;
        }
        if (index + 1 > N)
            return;
        gradientsA[cnt] = index + 1;
        isGradientA[index + 1] = true;
        chooseGradients(cnt + 1, index + 1);
        isGradientA[index + 1] = false;
        chooseGradients(cnt, index + 1);
    }// end of chooseGradients

    /**
     * 음식에 사용된 재료들의 시너지를 계산해 음식의 맛 구하는 메서드
     * @param arr   음식 재료 배열
     * @param cnt   시너지를 구할 재료 수
     * @param index 재료를 뽑기위한 인덱스
     */
    static void calcTasteOfFood(int[] arr, int cnt, int index) {
        if (cnt == 2) {
            tasteOfFood += calcSysnergy(selected[0], selected[1]);
            return;
        }
        if (index > arr.length - 1)
            return;
        selected[cnt] = arr[index];
        calcTasteOfFood(arr, cnt + 1, index + 1);
        calcTasteOfFood(arr, cnt, index + 1);
    }// end of calcTasteOfFood

    /**
     * 재료 간의 시너지 구하는 메서드
     * @param row
     * @param col
     * @return 시너지 값
     */
    static int calcSysnergy(int row, int col) {
        int synergy = 0;
        synergy += combTable[row][col];
        synergy += combTable[col][row];
        return synergy;
    }// end of calcSysnergy
}// end of class