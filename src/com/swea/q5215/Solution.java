package com.swea.q5215;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA Q5215 햄버거 다이어트
 */
public class Solution {
    static int N, L, maxScore, calorie, count;
    static int[][] ingredients;
    static int[] selected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            ingredients = new int[N][2];
            selected = new int[N];
            count = 0;
            maxScore = 0;
            calorie = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                ingredients[i][0] = Integer.parseInt(st.nextToken());
                ingredients[i][1] = Integer.parseInt(st.nextToken());
            }

            calcMaxScore(0, 0);
            bw.write("#" + tc + " " + maxScore);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    //
    static void calcMaxScore(int cnt, int start) {
        if(calorie>=L){
            int score = 0;
            int num = 0;
            if(calorie == L)
                num = count;
            else
                num = count-1;
            for (int i =0; i<num; i++) {
                score += ingredients[selected[i]][0];
            }
            maxScore = Math.max(maxScore, score);
            calorie = 0;
            count = 0;
            return;
        }
        for (int i = start; i < N; i++) {
            selected[cnt] = i;
            count++;
            calorie += ingredients[i][1];
            calcMaxScore(cnt + 1, i + 1);
        }
    }
}
