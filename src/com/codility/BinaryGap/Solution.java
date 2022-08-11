package com.codility.BinaryGap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        System.out.println(solution(input));
    }

    public static int solution(int N) {
        // write your code in Java SE 8
        StringBuilder sb = new StringBuilder();
        while(N != 0){
            int remains = N % 2;
            sb.append(String.valueOf(remains));
            N /= 2;
        }
        String binary = sb.toString();
        int oneCount = 0;
        boolean isStart = false;
        int zeroCount = 0;
        int maxCount = 0;
        for(char ch : binary.toCharArray()){
            if(ch == '1'){
                oneCount++;
                if(!isStart){
                    isStart = true;
                }else{
                    if(oneCount % 2 ==0){
                        maxCount = Math.max(maxCount, zeroCount);
                        zeroCount = 0;
                    }
                }
            }else if (ch == '0') {
                if(isStart){
                    zeroCount++;
                }
            }
        }
        return maxCount;
    }
}
