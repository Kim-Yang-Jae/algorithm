package com.boj.silver.q1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(getNthMovieName(N));
    }

    static int getNthMovieName(int N) {
        int cnt = 0, num = 665;
        List<Integer> remainders = new ArrayList<>();
        while (cnt != N) {
            num = num + 1;
            int sixCnt = 0, tmpNum = num;
            while (tmpNum != 0) {
                int remainder = tmpNum % 10;
                remainders.add(remainder);
                tmpNum /= 10;
                if (remainder == 6)
                    sixCnt++;
            }
            if (sixCnt < 3){
                remainders.clear();
                continue;
            }
            for (int i = 0; i <= remainders.size() - 3; i++) {
                if (remainders.get(i) == 6 && remainders.get(i + 1) == 6 && remainders.get(i + 2) == 6){
                    cnt++;
                    break;
                }
            }
            remainders.clear();
        }
        return num;
    }
}
