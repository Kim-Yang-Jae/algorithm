package com.boj.bronze.q2753;

import java.util.Scanner;

/**
 *  윤년 계산
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();
        int isLeapYear = 0;

        if (year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0)
                    isLeapYear = 1;
            }else
                isLeapYear = 1;
        }

        System.out.println(isLeapYear);
        sc.close();
    }
}
