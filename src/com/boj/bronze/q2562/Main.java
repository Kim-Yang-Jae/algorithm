package com.boj.bronze.q2562;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i = 1; i<=9; i++) {
            int num = Integer.parseInt(br.readLine());
            if(max<=num) {
                max = num;
                maxIndex = i;
            }
        }

        bw.write(max + "\n");
        bw.write(maxIndex + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
