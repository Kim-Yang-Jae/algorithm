package com.boj.silver.q2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        printCntCroatianAlphabet(input);
        br.close();
    }

    static void printCntCroatianAlphabet(String input){
        int count = 0;
        char[] charArr = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if(charArr[i] == 'c' || charArr[i] == 's'|| charArr[i] == 'z'){
                if(charArr[i+1]=='=' || charArr[i+1] == '-')
                    i++;
            }else if(charArr[i] == 'd'){
                if(charArr[i+1] == 'z' && charArr[i+2] == '=')
                    i+=2;
                else if(charArr[i+1] == '-')
                    i++;
            }else if(charArr[i] == 'l' || charArr[i] == 'n'){
                if(charArr[i+1] == 'j')
                    i++;
            }
            count++;
        }
        System.out.println(count);
    }
}
