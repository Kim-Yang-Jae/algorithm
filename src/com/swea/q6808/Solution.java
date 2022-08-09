package com.swea.q6808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * SWEA Q6808 규영이와 인영이의 카드게임
 */
public class Solution {
    static int[] gDeck = new int[9];
    static int[] iDeck = new int[9];
    static int[] selected = new int[9];
    static boolean[] isChecked;
    static boolean[] isSelected;
    static int numOfWin;
    static int numOfLost;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            isChecked = new boolean[19];
            isSelected = new boolean[9];
            numOfLost = numOfWin = 0;

            for (int i = 0; i < 9; i++) {
                gDeck[i] = Integer.parseInt(st.nextToken());
                isChecked[gDeck[i]] = true;
            }

            int count = 0;
            for (int i = 1; i <= 18; i++) {
                if (isChecked[i])
                    continue;
                iDeck[count] = i;
                count++;
            }

            calcNumOfWin(0);

            bw.write("#" + tc + " " + numOfWin + " " + numOfLost + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void calcNumOfWin(int cnt) {
        int gScore = 0;
        int iScore = 0;
        if (cnt == 9) {
            for (int i = 0; i < 9; i++) {
                if (gDeck[i] > selected[i])
                    gScore += (gDeck[i] + selected[i]);
                else
                    iScore += (gDeck[i] + selected[i]);
            }
            if (iScore > gScore) {
                numOfLost++;
            } else if (gScore > iScore) {
                numOfWin++;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (isSelected[i])
                continue;
            selected[cnt] = iDeck[i];
            isSelected[i] = true;

            calcNumOfWin(cnt + 1);
            isSelected[i] = false;
        }
    }
}

