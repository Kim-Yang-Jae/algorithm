package com.baekjoon.q1330;

import java.util.Scanner;

/**
 *   두 수 비교하기
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(A > B ? ">" : A < B ? "<" : "==");
        sc.close();
    }
}
