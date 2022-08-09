package com.boj.bronze.q11654;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BOJ Q11654 아스키 코드
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ch = br.readLine().charAt(0);
        bw.write(ch + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
