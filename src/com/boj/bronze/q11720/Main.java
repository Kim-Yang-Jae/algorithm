package com.boj.bronze.q11720;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BOJ Q11720 숫자의 합
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String numStr = br.readLine();
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            sum += (numStr.charAt(i) - '0');
        }
        bw.write(sum+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
