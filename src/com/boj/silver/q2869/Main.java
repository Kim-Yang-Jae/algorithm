package com.boj.silver.q2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ q2869 달팽이는 올라가고 싶다
 * 낮에 A미터 올라가고 밤에 B미터 미끄러짐
 * 나무 높이 V 올라가는데 며칠 걸리는지
 */
public class Main {
    static int A, B, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        sb.append(calcDaysClimbBar());
        System.out.println(sb.toString());
    }// end of main method

    /**
     * 달팽이가 막대를 올라가는데 며칠 걸리는지 구하는 메서드
     * @return
     */
    static int calcDaysClimbBar() {
        int oneDay = A - B; //하루에 총 올라가는 거리
        int result = 0;
        //마지막에 A만큼 올라가 정사에 도달하면 B만큼 내려올 일도 없기 때문에 V가 아닌 V-A로 계산
        if ((V - A) % oneDay == 0) // 나머지가 없으면 다음날 A만큼 올라가면 정상 도달
            result = ((V - A) / oneDay) + 1;
        else{ // 나머지가 있으면 다음날 oneDay 만큼 올라가고 그다음날 A만큼 올라가 정상 도달
            result = ((V - A)/ oneDay) + 2;
        }
        return result;
    }// end of calcDaysClimbBar
}// end of Main class
