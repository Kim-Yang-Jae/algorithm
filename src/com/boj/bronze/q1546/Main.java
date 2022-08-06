package com.boj.bronze.q1546;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int numOfSubjects = Integer.parseInt(input);
        double sum = 0;
        double max = 0;
        double[] scores = new double[numOfSubjects];

        input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        for (int i = 0; i < numOfSubjects; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, scores[i]);
        }
        for (int i = 0; i < numOfSubjects; i++) {
            scores[i] = (scores[i] / max) * 100;
            sum += scores[i];
        }
        bw.write((sum / numOfSubjects) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
