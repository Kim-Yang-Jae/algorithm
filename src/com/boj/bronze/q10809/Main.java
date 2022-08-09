package com.boj.bronze.q10809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * BOJ Q10809 알파벳 찾기
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int[] numOfChar = new int[26];
        Arrays.fill(numOfChar, -1);

        for(int i = 0; i<input.length();i++) {
            if(numOfChar[input.charAt(i)-'a'] == -1) {
                numOfChar[input.charAt(i)-'a'] = i;
            }
        }

        for(int i : numOfChar) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}