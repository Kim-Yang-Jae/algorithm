package com.swea.q1289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String memory = br.readLine();
            printMinCountChangeMemory(tc, memory);
        }
        br.close();
    }

    public static void printMinCountChangeMemory(int tc, String memory) {
        String tmp = "0";
        int count = 0;

        for (int i = 0; i < memory.length(); i++) {
            if (!tmp.equals(String.valueOf(memory.charAt(i)))) {
                if(tmp.equals("0"))
                    tmp = "1";
                else
                    tmp = "0";
                count++;
            }
        }

        System.out.printf("#%d %d\n", tc, count);
    }
}
