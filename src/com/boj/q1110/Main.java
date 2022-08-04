package com.boj.q1110;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int tmp = N;

        do {
            int units = tmp % 10;
            int tens = tmp < 10 ? 0 : tmp / 10;
            int result = (tens + units) % 10;
            tmp = (units * 10) + result;
            count++;
        } while (tmp != N);

        bw.write("" + count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
