package com.boj.silver.q4673;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static boolean[] isNotSelfNumber;
    public final static int MAX_Num = 10_000;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        isNotSelfNumber = new boolean[10_036];
        checkSelfNumber();
        for (int i = 1; i <= MAX_Num; i++) {
            if (!isNotSelfNumber[i])
                bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int d(int n) {
        int result = n;
        while (n != 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }

    public static void checkSelfNumber() {
        for (int i = 1; i <= MAX_Num; i++) {
            int index = d(i);
            if (!isNotSelfNumber[index])
                isNotSelfNumber[index] = true;
        }
    }
}
