package com.boj.bronze.q4344;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int T = Integer.parseInt(input);
        for (int tc = 0; tc < T; tc++) {
            input = br.readLine();
            double result = calcPercentageOutstandingStudent(input);
            System.out.printf("%.3f%%\n", result);
        }
        br.close();
    }

    public static double calcPercentageOutstandingStudent(String input){
        StringTokenizer st = new StringTokenizer(input);
        int numOfStudents = Integer.parseInt(st.nextToken());
        int[] scores = new int[numOfStudents];
        double sum = 0;
        double avg = 0;

        for (int i = 0; i < numOfStudents; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            sum += scores[i];
        }
        avg = sum / numOfStudents;

        double count = 0;
        for (int i = 0; i < numOfStudents; i++) {
            if (avg < scores[i])
                count++;
        }
        return (count/numOfStudents)*100;
    }
}
