package com.boj.bronze.q8958;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int T = Integer.parseInt(input);
        for (int tc = 0; tc < T; tc++) {
            input = br.readLine();
            int score = calcScore(input);
            bw.write(score + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calcScore(String input) {
        int consecutiveNum = 0;
        int score = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X') {
                consecutiveNum = 0;
            } else {
                consecutiveNum++;
                score += consecutiveNum;
            }
        }
        return score;
    }
}
