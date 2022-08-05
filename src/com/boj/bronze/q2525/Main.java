package com.boj.bronze.q2525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int cookingTime = Integer.parseInt(bf.readLine());

        hour = (minute + cookingTime) >= 60
                ? hour + ((minute + cookingTime) / 60) >= 24 ? hour + ((minute + cookingTime) / 60) - 24
                : hour + ((minute + cookingTime) / 60)
                : hour;
        minute = (minute + cookingTime) >= 60 ? (minute + cookingTime) % 60 : (minute + cookingTime);

        System.out.println(hour + " " + minute);
    }
}
