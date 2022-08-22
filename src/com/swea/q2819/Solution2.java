package com.swea.q2819;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    static char[][] matrix;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Set<String> numSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            matrix = new char[4][4];


            for (int r = 0; r < 4; r++) {
                String str = br.readLine();
                for (int c = 0, index = 0; c < 4; c++, index += 2) {
                    matrix[r][c] = str.charAt(index);
                }
            }

            numSet = new HashSet<>();
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                   go(r, c, 1,"");
                }
            }
            bw.write("#" + tc + " " + numSet.size() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void go(int row, int col, int step, String str) {
        if(row < 0 || row>=4 || col < 0 || col >= 4)
            return;
        str += matrix[row][col];
        if(step==7){
            numSet.add(str);
            return;
        }
        for (int i = 0; i < 4; i++) {
            go(row+deltas[i][0],col+deltas[i][1],step + 1, str);
        }

    }
}
