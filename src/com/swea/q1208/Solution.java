package com.swea.q1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            Integer[] box = new Integer[100];
            int numOfDump = Integer.parseInt(br.readLine());

            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            for (int i = 0; i < box.length; i++) {
                box[i] = Integer.parseInt(st.nextToken());
            }

            printDifference(tc, numOfDump, box);

        }
        br.close();
    }

    public static void printDifference(int tc, int numOfDump, Integer[] box) {
        int max = 0;
        int min = 100;
        for (int i = 0; i <= numOfDump; i++) {
            Arrays.sort(box, Collections.reverseOrder());
            max = 0;
            min = 100;
            max = Math.max(box[0], max);
            min = Math.min(box[99], min);
            if (i == numOfDump)
                break;
            box[0] = max - 1;
            box[99] = min + 1;
        }

        System.out.printf("#%d %d\n", tc, max - min);
    }
}
