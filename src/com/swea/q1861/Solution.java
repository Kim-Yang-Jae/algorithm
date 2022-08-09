package com.swea.q1861;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA Q1861 정사각형 방
 */
public class Solution {
    public static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int N;
    public static int[][] rooms;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            rooms = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append(calcMaxNumOfRoomMoved());
            System.out.println(sb.toString());
        }
    }

    public static String calcMaxNumOfRoomMoved() {
        int max = 0;
        int startNum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tmpI = i, tmpJ = j, count = 1;
                while (true) {
                    int roomNum = rooms[tmpI][tmpJ];
                    boolean isCheck = false;
                    for (int d = 0; d < 4; d++) {
                        tmpI += deltas[d][0];
                        tmpJ += deltas[d][1];
                        if (tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < N) {
                            if (rooms[tmpI][tmpJ] == roomNum + 1) {
                                count++;
                                roomNum++;
                                isCheck = true;
                                break;
                            } else {
                                tmpI -= deltas[d][0];
                                tmpJ -= deltas[d][1];
                            }
                        } else {
                            tmpI -= deltas[d][0];
                            tmpJ -= deltas[d][1];
                        }
                    }
                    if (!isCheck)
                        break;
                }
                if (count > max) {
                    max = count;
                    startNum = rooms[i][j];
                } else if (count == max) {
                    startNum = Math.min(rooms[i][j], startNum);
                }
            }
        }
        sb.append(startNum).append(" ").append(max);
        return sb.toString();
    }
}
