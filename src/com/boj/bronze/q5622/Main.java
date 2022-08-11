package com.boj.bronze.q5622;

import java.io.*;

public class Main {
    static int[] numArr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        numArr = changeCharToNum(input);
        printMinTime();
        br.close();
    }

    static int[] changeCharToNum(String input) {
        int count = 0;
        int[] result = new int[input.length()];
        for (char ch : input.toCharArray()) {
            switch (ch){
                case 'A': case 'B': case 'C':
                    result[count++] = 2;
                    break;
                case 'D': case 'E': case 'F':
                    result[count++] = 3;
                    break;
                case 'G': case 'H': case 'I':
                    result[count++] = 4;
                    break;
                case 'J': case 'K': case 'L':
                    result[count++] = 5;
                    break;
                case 'M': case 'N': case 'O':
                    result[count++] = 6;
                    break;
                case 'P': case 'Q': case 'R': case 'S':
                    result[count++] = 7;
                    break;
                case 'T': case 'U': case 'V':
                    result[count++] = 8;
                    break;
                case 'W': case 'X': case 'Y': case 'Z':
                    result[count++] = 9;
                    break;
            }
        }
        return result;
    }

    static void printMinTime(){
        int time = 0;
        for(int num : numArr){
            time += num + 1;
        }
        System.out.println(time);
    }
}
