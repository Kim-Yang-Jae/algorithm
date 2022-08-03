package com.boj.q2741;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int N = Integer.parseInt(input);

        for (int i = 0; i < N; i++) {
            bw.write("" + (i + 1) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
