package com.boj.bronze.q2480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());

        int money = 0;
        int max = 0;
        if (first == second && second == third) {
            money = 10000 + (first * 1000);
        } else if (first == second || first == third) {
            money = 1000 + (first * 100);
        } else if (second == third) {
            money = 1000 + (second * 100);
        } else {
            max = first > second ? Math.max(first, third) : Math.max(second, third);
            money = max * 100;
        }

        System.out.println(money);
    }
}
