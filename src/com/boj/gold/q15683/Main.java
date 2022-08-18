package com.boj.gold.q15683;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] office;
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][][] directs = {{{0}}, {{0}, {1}, {2}, {3}}, {{0, 1}, {2, 3}}, {{0, 2}, {0, 3}, {1, 2}, {1, 3}}, {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}}, {{0, 1, 2, 3}}};
    static List<CCTV> cctvList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;
        office = new int[N][M];
        cctvList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvList.add(new CCTV(i, j, office[i][j]));
                }
            }
        }

        getMinNumOfBlindSpot();
        System.out.println(result);
    }

    static class CCTV {
        int row, col;
        int type;

        public CCTV(int row, int col, int type) {
            this.row = row;
            this.col = col;
            this.type = type;
        }
    }

    static void getMinNumOfBlindSpot() {
        for (CCTV cctv : cctvList) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < directs[cctv.type].length; i++) {
                int[][] copyOffice = deepCopy();
                int count = 0, row = cctv.row, col = cctv.col;
                for (int j = 0; j < directs[cctv.type][i].length; j++) {
                    int d = directs[cctv.type][i][j];
                    while (true) {
                        row += deltas[d][0];
                        col += deltas[d][1];
                        if (row < 0 || row >= N || col < 0 || col >= M || copyOffice[row][col] == 6)
                            break;
                        copyOffice[row][col] = -1;
                    }
                    count += getNumOfBlindSpot(copyOffice);
                }
                min = Math.min(count,min);
            }
            result += min;
        }
    }

    static int[][] deepCopy() {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(office[i], 0, copyMap[i], 0, M);
        }
        return copyMap;
    }

    static int getNumOfBlindSpot(int[][] copyOffice) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyOffice[i][j] == 0)
                    count++;
            }
        }
        return count;
    }

}
