package com.boj.silver.q1065;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(countHanNum(N) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int countHanNum(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (i < 100) {
                count++;
                continue;
            }else if(i==1000)
                break;
            int[] numOfPosition = new int[3];
            int difference = 0;

            int position = 2;
            int num = i;
            while (num != 0) {
                numOfPosition[position] = num % 10;
                position--;
                num = num / 10;
            }
            if (numOfPosition[2] - numOfPosition[1] == numOfPosition[1] - numOfPosition[0])
                count++;
        }
        return count;
    }
}
