package com.boj.bronze.q10818;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int max = -1_000_000;
        int min = 1_000_000;

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        for(int i = 1; i<=N; i ++) {
            int num = Integer.parseInt(st.nextToken());
            max= Math.max(max, num);
            min= Math.min(min, num);
        }

        bw.write(min + " " + max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
