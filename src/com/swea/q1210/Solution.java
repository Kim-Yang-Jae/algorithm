package com.swea.q1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = 0;

        while (test_case < 10) {
            int[][] ladderGame = new int[100][100];
            test_case = Integer.parseInt(br.readLine());

            for (int i = 0; i < ladderGame.length; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);

                for (int j = 0; j < ladderGame.length; j++) {
                    ladderGame[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            printWinningStartPoint(ladderGame, test_case);
        }

    }

    public static void printWinningStartPoint(int[][] ladderGame, int test_case) {

        int resultJ = -1;

        for (int j = 0; j < ladderGame.length; j++) {
            int i = 99;
            if (ladderGame[i][j] == 2) {
                int tmpI = i - 1;
                int tmpJ = j;
                while (tmpI != 0) {
                    for (int k = tmpJ + 1; k < ladderGame.length; k++) {
                        if (ladderGame[tmpI][k] == 1) {
                            tmpJ = k;
                            ladderGame[tmpI][k] = 0;
                        } else
                            break;
                    }

                    for (int k = tmpJ - 1; k >= 0; k--) {
                        if (ladderGame[tmpI][k] == 1) {
                            tmpJ = k;
                            ladderGame[tmpI][k] = 0;
                        } else
                            break;
                    }

                    tmpI--;
                    ladderGame[tmpI][tmpJ] = 0;
                }
                resultJ = tmpJ;
                break;
            }
        }

        System.out.printf("#%d %d\n", test_case, resultJ);
    }
}
