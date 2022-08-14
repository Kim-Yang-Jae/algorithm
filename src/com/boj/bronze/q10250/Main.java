package com.boj.bronze.q10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ Q10250 ACM호텔
 * 엘리베이터 거리 신경 X
 * 걷는 거리가 같으면 아래층 선호
 * 입구에서 가까운 방부터 배정
 */
public class Main {
    static int H, W, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            sb.append(calcRoomNumber()).append("\n");
        }
        System.out.println(sb.toString());
    }// end of main method

    /**
     * N번째 손님의 방번호 구하기
     * @return 손님의 방번호
     */
    static String calcRoomNumber() {
        int count = 0;
        StringBuilder roomNum = new StringBuilder();
        //엘리베이터에서 부터의 거리가 같다면 아래층부터 선호하므로 row 부터 채우고 다음에 col을 채우는 형식
        Loop:
        for (int col = 1; col <= W; col++) {
            for (int row = 1; row <= H; row++) {
                count++;
                if (count == N) { //N번째 손님일 때
                    if (col < 10) //col이 10보다 작으면 앞에 0붙여주기
                        roomNum.append(String.valueOf(row)).append("0").append(String.valueOf(col));
                    else
                        roomNum.append(String.valueOf(row)).append(String.valueOf(col));
                }
            }
        }
        return roomNum.toString();
    }// end of calcRoomNumber
}// end of Main class
