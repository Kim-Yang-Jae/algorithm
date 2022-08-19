package com.swea.q3234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA Q3234 준환이의 양팔저울
 * 순열, 부분집합
 */
public class Solution {
    static int N, count;
    static int[] weights, selected;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            count = 0;
            weights = new int[N];
            selected = new int[N];
            visited = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }

            perm(0);
            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }// end of main method

    /**
     * 무게 추 올리는 순서를 정하는 순열 메서드
     * @param cnt 올린 추의 개수
     */
    static void perm(int cnt) {
        if (cnt == N) {
            comb(0, 0, 0);
            return;
        }
        for (int index = 0; index < N; index++) {
            if (visited[index])
                continue;
            visited[index] = true;
            selected[cnt] = weights[index];
            perm(cnt + 1);
            visited[index] = false;
        }
    }// end of perm method;

    /**
     * 무게추를 분배하는 조합 순열
     * @param index       무게 추 인덱스
     * @param leftWeight  왼쪽 저울
     * @param rightWeight 오른쪽 저울
     */
    static void comb(int index, int leftWeight, int rightWeight) {
        if (index == N) {
            count++;
            return;
        }
        comb(index + 1, leftWeight + selected[index], rightWeight);
        if (rightWeight + selected[index] <= leftWeight)
            comb(index + 1, leftWeight, rightWeight + selected[index]);
    }// end of comb method
}// end of Main class
