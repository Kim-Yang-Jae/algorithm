package com.boj.bronze.q2577;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int result = A * B * C;
        int[] numArr = new int[10];

        while (true) {
            numArr[result % 10] = numArr[result % 10] + 1;
            result = result / 10;
            if (result / 10 == 0 && result % 10 == 0)
                break;
        }

        for (int i = 0; i < 10; i++) {
            bw.write(numArr[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
