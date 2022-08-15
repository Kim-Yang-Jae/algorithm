package com.boj.bronze.q10757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ Q10757 큰수 A+B
 * A + B 출력
 * 0< A,B < 10^(10000)
 */
public class Main {
    static int maxLength;
    static int[] numA, numB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        maxLength = Math.max(A.length(), B.length());//A와 B중 더 긴 값을 배열의 크기로 설정
        numA = new int[maxLength + 1]; //A를 저장할 배열(합에서 올림값이 생길수 있으므로 +1)
        numB = new int[maxLength + 1]; //B를 저장할 배열(합에서 올림값이 생길수 있으므로 +1)
        stringToIntArray(A, B);
        System.out.println(plusTooBingNum());
    }// end of main method

    /**
     * String 형태의 두 큰 정수를 배열 형태로 저장
     * @param A
     * @param B
     */
    static void stringToIntArray(String A, String B) {
        int count = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            numA[count++] = A.charAt(i) - '0';
        }
        count = 0;
        for (int i = B.length() - 1; i >= 0; i--) {
            numB[count++] = B.charAt(i) - '0';
        }
    }// end of stringToIntArray method

    /**
     *
     * @return
     */
    static String plusTooBingNum() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            int result = numA[i] + numB[i]; // i번째 자리 계산
            numA[i] = result % 10;
            if (result / 10 != 0) // i번째 계산 결과가 10보다 크면 올림값 처리
                numA[i + 1] = numA[i + 1] + result / 10;
        }
        if(numA[maxLength] != 0){ // 마지막 숫자가 0이 아니면 표시
            sb.append(numA[maxLength]);
        }
        for (int i = maxLength-1; i >=0; i--) {
            sb.append(numA[i]);
        }
        return sb.toString();
    }// end of plusTooBingNum method
}// end of Main class
