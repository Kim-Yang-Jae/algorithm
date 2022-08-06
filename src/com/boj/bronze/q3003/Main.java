package com.boj.bronze.q3003;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] chessPieces = {1, 1, 2, 2, 2, 8};

        String input = br.readLine();
        StringTokenizer st= new StringTokenizer(input);
        for (int i = 0; i < chessPieces.length; i++) {
            bw.write((chessPieces[i] - Integer.parseInt(st.nextToken())) + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
