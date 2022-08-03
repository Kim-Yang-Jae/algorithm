package com.boj.q10871;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        input = br.readLine();
        st = new StringTokenizer(input);

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num< X)
                bw.write("" + num + " ");
        }
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

