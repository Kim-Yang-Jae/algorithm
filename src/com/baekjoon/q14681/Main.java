package com.baekjoon.q14681;

import java.util.Scanner;

/**
 *   사분면 계산
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int quadrant;

        if(x>0 && y>0)
            quadrant = 1;
        else if(x>0 && y< 0)
            quadrant = 4;
        else if(x<0 && y<0)
            quadrant = 3;
        else
            quadrant = 2;

        System.out.println(quadrant);
        sc.close();
    }
}
