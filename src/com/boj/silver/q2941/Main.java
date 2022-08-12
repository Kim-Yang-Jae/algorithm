package com.boj.silver.q2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  BOJ Q2941 크로아티아 알파벳
 *      č -> c=
 *      ć -> c-
 *      dž -> dz=
 *      đ -> d-
 *      lj -> lj
 *      nj -> nj
 *      š -> s=
 *      ž -> z=
 *  입력되 단어가 몇개의 크로아티아 알파벳으로 구성되어 있는지 출력
 *  위 목록에 없는 크로아티아 알파벳은 한 글자로 계산
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        printCntCroatianAlphabet(input);
        br.close();
    }// end of main method

    /**
     * 크로아티아 알파벳 갯수를 계산하고 출력하는 메서드
     * @param input 단어를 입력 받음
     */
    static void printCntCroatianAlphabet(String input) {
        int count = 0;
        input = input.replace("c=", "!");
        input = input.replace("c-", "!");
        input = input.replace("dz=", "!");
        input = input.replace("d-", "!");
        input = input.replace("lj", "!");
        input = input.replace("nj", "!");
        input = input.replace("s=", "!");
        input = input.replace("z=", "!");
        for (char ch : input.toCharArray()) {
            count++;
        }
        System.out.println(count);
    }// end of printCntCroatianAlphabet method
}//end of Main class
