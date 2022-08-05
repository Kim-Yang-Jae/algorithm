package com.boj.silver.q1244;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numOfSwitch = sc.nextInt();
        int[] switchStates = new int[numOfSwitch];

        for (int i = 0; i < numOfSwitch; i++) {
            switchStates[i] = sc.nextInt();
        }

        int numOfStudent = sc.nextInt();
        int[][] student = new int[numOfStudent][2];

        for (int i = 0; i < numOfStudent; i++) {
            student[i][0] = sc.nextInt();
            student[i][1] = sc.nextInt();
        }

        printswitchStates(switchStates, student);

        sc.close();
    }

    public static void printswitchStates(int[] switchStates, int[][] student) {

        for (int i = 0; i < student.length; i++) {
            if (student[i][0] == 1) {
                int num = student[i][1];
                for (int j = 1; j <= switchStates.length; j++) {
                    if (j * num > switchStates.length)
                        break;
                    switchStates[(j * num) - 1] = toggleState(switchStates[(j * num) - 1]);
                }
            } else if(student[i][0] == 2) {
                int standardIndex = student[i][1] - 1;
                int startIndex = 0;
                int endIndex = 0;
                for (int j = 1; j < switchStates.length / 2; j++) {
                    if (standardIndex - j < 0 || standardIndex + j >= switchStates.length) {
                        break;
                    }
                    if (switchStates[standardIndex - j] == switchStates[standardIndex + j]) {
                        startIndex = standardIndex - j;
                        endIndex = standardIndex + j;
                    } else
                        break;
                }
                if (startIndex == 0 && endIndex == 0)
                    switchStates[standardIndex] = toggleState(switchStates[standardIndex]);
                else {
                    for (int k = startIndex; k <= endIndex; k++) {
                        switchStates[k] = toggleState(switchStates[k]);
                    }
                }
            }
        }

        for (int i = 0; i < switchStates.length; i++) {
            System.out.print(switchStates[i] + " ");
            if((i+1)%20==0) System.out.println();
        }
        System.out.println();
    }

    public static int toggleState(int switchState) {
        if (switchState == 1)
            return 0;
        else
            return 1;
    }
}