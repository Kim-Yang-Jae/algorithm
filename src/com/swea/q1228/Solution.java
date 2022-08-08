package com.swea.q1228;

import java.util.*;
import java.io.*;

/**
 * SWEA Q1288 암호문
 */
public class Solution {
    static List<String> cryptogram;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= 10; tc++) {
            cryptogram = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                cryptogram.add(i, st.nextToken());
            }

            int numOfCommands = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            insertCodes(numOfCommands, st);
            printCryptogram(bw, tc);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void insertCodes(int numOfCommands, StringTokenizer st) {
        for (int i = 0; i < numOfCommands; i++) {
            String tmp = st.nextToken();
            int insertIndex = Integer.parseInt(st.nextToken());
            int numOfCodes = Integer.parseInt(st.nextToken());
            for (int k = 0; k < numOfCodes; k++) {
                cryptogram.add(insertIndex, st.nextToken());
                insertIndex++;
            }
        }
    }

    public static void printCryptogram(BufferedWriter bw, int tc) throws IOException {
        bw.write("#" + tc + " ");
        for (int i = 0; i < 10; i++) {
            bw.write(cryptogram.get(i) + " ");
        }
        bw.write("\n");
    }
}
