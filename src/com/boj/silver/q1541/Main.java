package com.boj.silver.q1541;

import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BOJ Q1541 잃어버린 괄호
 * 양수, +, -, 괄호를 이용해 수식 생성
 * 수식의 결과가 최솟값이 되도록 괄호 넣기
 */
public class Main {
    static int min;
    static List<Integer> numList;
    static List<Character> signList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        numList = new ArrayList<>();
        signList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                sb.append(input.charAt(i));
            } else {
                numList.add(Integer.parseInt(sb.toString()));
                signList.add(input.charAt(i));
                sb = new StringBuilder();
            }
        }
        numList.add(Integer.parseInt(sb.toString()));

        getMinResult();
        System.out.println(min);
    }// end of main method

    static void getMinResult() {
        int tmpNum = 0;
        for (int i = 0; i < signList.size(); i++) {
            if (signList.get(i) == '-')
                continue;
            tmpNum = numList.get(i) + numList.get(i + 1);
            numList.remove(i);
            numList.remove(i);
            numList.add(i, tmpNum);
            signList.remove(i);
            i--;
        }
        for (int i = 0; i < signList.size(); i++) {
            tmpNum = numList.get(i) - numList.get(i + 1);
            numList.remove(i);
            numList.remove(i);
            numList.add(i, tmpNum);
            signList.remove(i);
            i--;
        }
        min = numList.get(0);
    }
}// end of Main class
