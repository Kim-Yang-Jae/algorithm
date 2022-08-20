package com.boj.bronze.q2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  BOJ Q2798 블랙잭
 *  조합
 */
public class Main {
    static int N, M, max;
    static int[] cards; //카드를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = 0; //뽑은 3장의 카드의 합의 최댓값을 구하는 변수
        cards = new int[N]; //N장의 카드 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        getSumOfCard(0,0,0); //조합을 통해 가장 큰 카드의 합 구하기
        sb.append(max);
        System.out.println(sb.toString());
        br.close();
    }// end of main method

    /**
     * 3장을 뽑아 M보다 같거나 작은 카드들의 합의 최댓갑ㅅ을 조합으로 구하는 메서드
     * @param cnt 뽑은 카드의 수
     * @param index 카드를 뽑기위한 index
     * @param sum 뽑은 카드의 합
     */
    static void getSumOfCard(int cnt, int index, int sum) {
        if (cnt == 3) { //카드를 3장 뽑으면 메서드 종료
            if(sum <= M) //합이 M보다 작거나 같으면 최댓값 비교 후 갱신
                max = Math.max(max, sum);
            return;
        }
        if (index >= N) //index가 카드의 수보다 커지면 메서드 종료
            return;
        getSumOfCard(cnt + 1, index + 1, sum + cards[index]); //카드를 뽑았을때
        getSumOfCard(cnt, index + 1, sum); //카드를 뽑지 않았을 때
    }// end of getSumOfCard method
}// end of Main class
