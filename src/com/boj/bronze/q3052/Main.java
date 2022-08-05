package com.boj.bronze.q3052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] remainders = new int[42];
        int cnt= 0;

        for(int i = 0; i< 10; i++) {
            int num = Integer.parseInt(br.readLine());
            remainders[num%42]++;
        }
        for(int i = 0; i< 42; i++) {
            if(remainders[i] != 0) {
                cnt++;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
