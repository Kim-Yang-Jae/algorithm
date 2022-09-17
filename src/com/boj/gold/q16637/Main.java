package com.boj.gold.q16637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, max;
    static char[] inputArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        max = Integer.MIN_VALUE;
        N = Integer.parseInt(br.readLine());
        inputArr = new char[N];
        String input = br.readLine();
        inputArr = input.toCharArray();
        getMaxNum(2, inputArr[0] - '0');
        System.out.println(max);
    }

    static void getMaxNum(int index, int sum) {
        if (index >= N) {
            max = Math.max(max, sum);
            return;
        }
        getMaxNum(index + 2, calculator(sum, inputArr[index] - '0', inputArr[index - 1]));

        if(index + 2 < N) {
            int r = calculator(inputArr[index] - '0', inputArr[index + 2] - '0', inputArr[index + 1]);
            int l = calculator(sum, r, inputArr[index - 1]);
            getMaxNum(index + 4, l);
        }
    }

    static int calculator(int n1, int n2, char operator) {
        if (operator == '+')
            return n1 + n2;
        else if (operator == '-')
            return n1 - n2;
        else
            return n1 * n2;
    }
}
