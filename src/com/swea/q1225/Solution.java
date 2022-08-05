package com.swea.q1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while ((input = br.readLine()) != null) {
            int tc = Integer.parseInt(input);
            Queue<Integer> encoder = new LinkedList<>();
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            for (int i = 0; i < 8; i++) {
                encoder.offer(Integer.parseInt(st.nextToken()));
            }
            Loop: while (true) {
                for (int i = 1; i <= 5; i++) {
                    int tmp = encoder.poll();
                    if (tmp - i <= 0) {
                        encoder.offer(0);
                        break Loop;
                    }else {
                        encoder.offer(tmp-i);
                    }

                }
            }

            System.out.printf("#%d ", tc);
            while(!encoder.isEmpty()){
                System.out.print(encoder.poll() + " ");
            }
            System.out.println();
        }
    }
}
