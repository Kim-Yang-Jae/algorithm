package com.boj.silver.q1316;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 *  BOJ Q1316 그룹단어 체커
 *  그룹단어 : 단어에 존재하는 모든 문자에 대해 각 문자가 연속해서 나타나는 경우만 있는 단어
 *  aabbcc -> O  abbcb -> X
 *  단어 N개 중 그룹단어 갯수 출력
 */
public class Main {
    //그룹단어 개수
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numOfWords = Integer.parseInt(br.readLine());
        cnt = 0;

        for (int i = 0; i < numOfWords; i++) {
            String input = br.readLine();
            checkGroupWord(input);
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }//end of main method

    /**
     * 그룹단어 여부 체크 메서드
     * @param input 입력된 단어
     */
    static void checkGroupWord(String input) {
        // 중복을 제거를 하기 위해 set 자료구조 사용
        Set<Character> charSet = new HashSet<>();
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length()) { //단어의 처음부터 마지막 문자 전 문자 까지 확인
                //문자가 변했을 때 set에 넣어서 중복 체크
                if (input.charAt(i) != input.charAt(i + 1)) {
                    num++;
                    charSet.add(input.charAt(i));
                }
            }else if( i -1 > 0){ //단어의 마지막 문자 확인
                num++;
                charSet.add(input.charAt(i));
            }else{ //1개의 문자만 가진 단어는 무조건 그룹단어
                cnt++;
                return;
            }
        }
        //set에 들어간 문자의 개수와 문자가 바뀐 횟수가 같으면 그룹단어
        if (num == charSet.size())
            cnt++;
    }// end of checkGroupWord method
}// end of Main class
