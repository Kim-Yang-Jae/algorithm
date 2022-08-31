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
    static int[] direction;
    static List<CCTV> cctvList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
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

        direction = new int[cctvList.size()];
        dfs(0);
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

    static void dfs(int cnt) {
        if (cnt == cctvList.size()) {
            int[][] copy = deepCopy();
            for (int i = 0; i< cctvList.size(); i++) {
                CCTV cctv = cctvList.get(i);
                monitoringDirection(cctv, direction[i], copy);
            }
            result = Math.min(getNumOfBlindSpot(copy),result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            direction[cnt] = i;
            dfs(cnt + 1);
        }
    }

    static void monitoringDirection(CCTV cctv, int dir, int[][] copy) {
        int type = cctv.type;
        if (type == 1) {
            monitoringRange(cctv, directs[type][dir], copy);
        } else if (type == 2) {
            if (dir == 0 || dir == 1)
                monitoringRange(cctv, directs[type][0], copy);
            else
                monitoringRange(cctv, directs[type][1], copy);
        } else if (type == 3 || type == 4) {
            monitoringRange(cctv, directs[type][dir], copy);
        } else if (type == 5) {
            monitoringRange(cctv, directs[type][0], copy);
        }
    }

    static void monitoringRange(CCTV cctv, int[] dirs, int[][] copy) {
        for (int dir : dirs) {
            int tmpR = cctv.row + deltas[dir][0];
            int tmpC = cctv.col + deltas[dir][1];
            while (tmpR >= 0 && tmpR < N && tmpC >= 0 && tmpC < M && copy[tmpR][tmpC] != 6){
                copy[tmpR][tmpC] = -1;
                tmpR += deltas[dir][0];
                tmpC += deltas[dir][1];
            }
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
