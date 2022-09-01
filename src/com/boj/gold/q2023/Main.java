package com.boj.gold.q2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        makePrimeNum(0,"");

        System.out.println(sb.toString());
    }

    static void makePrimeNum(int cnt, String number) {
        if (cnt == N) {
            sb.append(number).append("\n");
            return;
        }
        int[] numbers = null;
        if (cnt == 0)
            numbers = new int[]{2, 3, 5, 7};
        else
            numbers = new int[]{1, 3, 7, 9};
        for(int num : numbers){
            String checkStr = number + num;
            if(isPrime(Integer.parseInt(checkStr)))
                makePrimeNum(cnt + 1, checkStr);
        }
    }

    static boolean isPrime(int num){
        if(num<2)
            return false;
        for (int i = 2; i*i <= num; i++) {
            if(num%i == 0)
                return false;
        }
        return true;
    }
}
