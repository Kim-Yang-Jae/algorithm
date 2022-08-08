package com.boj.silver.q12891;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int A = 0, C = 1, G = 2, T = 3;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dnaSequence = br.readLine();
        input = br.readLine();
        st = new StringTokenizer(input);
        char[] charArr = new char[p];
        int start = 0;
        int end = start + p;
        int[] targets = new int[4];
        int[] cnts = new int[4];

        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = dnaSequence.charAt(i);
        }
        for (int i = 0; i < 4; i++) {
            targets[0] = Integer.parseInt(st.nextToken());
        }
    }


}
