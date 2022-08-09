package com.boj.bronze.q2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ Q2675 문자열 반복
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc< T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int repeatNum = Integer.parseInt(st.nextToken());
            String sentence = st.nextToken();
            printRepeatSentence(repeatNum, sentence);
        }
    }

    public static void printRepeatSentence(int repeatNum, String sentence) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<sentence.length(); i++) {
            for(int j =0; j<repeatNum; j++) {
                sb.append(sentence.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
