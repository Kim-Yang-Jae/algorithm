package com.boj.gold.q1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ Q1759 암호만들기
 * 순열
 */
public class Main {
    static int L, C; //L -> 암호의 글자수, C -> 암호가 될수 있는 문자의 개수
    static char[] alphabets; //암호가 될수 있는 문자 저장 배열
    static char[] code; //암호를 저장할 배열
    static boolean[] isCheck; //문자의 사용 여부 확인
    static List<String> codes; // 코드의 사전식 정렬하기 위한 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabets = new char[C];
        code = new char[L];
        isCheck = new boolean[C];
        codes = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int cnt = 0; cnt < C; cnt++) {
            alphabets[cnt] = st.nextToken().charAt(0);
        }
        getDecodedCode(0); //codes 리스트에 가능한 코드 목록 저장
        Collections.sort(codes); //codes 사전식으로 오름차순 정렬
        for (String code : codes) {
            if (check(code)) //코드에 최소 모음1개 자음2개가 포함되어있는지 확인
                sb.append(code).append("\n"); //모든 조건 만족한 암호 출력
        }
        System.out.println(sb.toString());
    }// end of main method

    /**
     * 암호로 사용가능한 문자열를 뽑는 순열 메서드
     * @param cnt 뽑은 문자 수
     */
    static void getDecodedCode(int cnt) {
        if (cnt == L) { //L개의 문자를 뽑았다면
            codes.add(String.valueOf(code)); //String 으로 변환해 codes 리스트에 저장
            return;
        }
        for (int index = 0; index < C; index++) {
            if (isCheck[index]) //문자를 뽑은적이 있는 문자라면 다음 경우의 수
                continue;
            if (cnt != 0 && code[cnt - 1] > alphabets[index]) //암호의 알파벳이 증가하는 형태가 아니라면 다음 경우의 수
                continue;
            code[cnt] = alphabets[index]; //조건 만족 시 해당 문자 암호로 사용
            isCheck[index] = true; //뽑은 적 있다고 표시
            getDecodedCode(cnt + 1); //다음 문자 뽑기
            isCheck[index] = false;
        }
    }// end of getDecodedCode method

    /**
     * 암호에 최소 자음 2개 모음 1개가 포함되어있는지 확인 하는 메서드
     * @param input 암호
     * @return
     */
    static boolean check(String input) {
        int vowelCnt = 0; //모음 개수
        int consonantCnt = 0; //자음 개수
        String vowel = "aeiou"; //모음 판별을 위한 문자열
        for (char ch : input.toCharArray()) { //암호의 모음개수 자음 개수 확인
            if (vowel.contains(String.valueOf(ch))) //모음에 해당하면 모음 개수 증가
                vowelCnt++;
            else //자음에 해당하면 자음 개수 증가
                consonantCnt++;
        }
        return vowelCnt >= 1 && consonantCnt >= 2; //최소 자음이 2개 모음이 1개이면 true, 아니면 false
    }// end of check method
}// end of Main class
