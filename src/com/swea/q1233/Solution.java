package com.swea.q1233;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * SWEA Q1233 사칙연산 유효성 검사
 */
public class Solution {
    static String Operators = "+-*/";

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= 10; tc++) {
            int numOfNode = Integer.parseInt(br.readLine());
            String[] nodeArr = new String[numOfNode + 1];

            for (int i = 0; i < numOfNode; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String value = st.nextToken();
                nodeArr[num] = value;
            }

            int result = checkArithmeticOperation(nodeArr);

            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int checkArithmeticOperation(String[] nodeArr) {
        int result = 1;
        for (int i = nodeArr.length - 1; i >= 1; i--) {
            if (Operators.contains(nodeArr[i])) {
                if (i * 2 > nodeArr.length - 1) {
                    result = 0;
                    break;
                }
            } else {
//				if (!Operators.contains(nodeArr[i / 2])) {
//					result = 0;
//					break;
//				}
//				result = 1;
                if (i <= (nodeArr.length - 1) / 2) {
                    result = 0;
//					break;
                }
            }
        }
        return result;
    }
}

