package com.swea.q5644;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA Q5644 무선 충전
 * 무선 충전기의 위치, 충전범위, 성능 입력
 * 두 지점사이 거리 D = |x1 - x2| + |y1 - y2|
 * 10*10 지도, 사용자 A(1,1) 사용자 B(10,10)두명
 * 모든 사용자가 충전한 양의 합의 최댓값
 */
public class Solution {
    static int M, A;
    static int[][] deltas = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[] moveA, moveB;
    static BatteryCharger[] bcs;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            moveA = new int[M + 1];
            moveB = new int[M + 1];
            bcs = new BatteryCharger[A];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                bcs[i] = new BatteryCharger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(bcs);

            sb.append("#").append(tc).append(" ").append(getSumOfPerformance()).append("\n");
        }
        System.out.println(sb.toString());

    }// end of main method

    /**
     * bc의 정보 저장을 위한 class
     */
    static class BatteryCharger implements Comparable<BatteryCharger> {
        int x, y;
        int coverage;
        int performance;

        public BatteryCharger(int x, int y, int coverage, int performance) {
            super();
            this.x = x;
            this.y = y;
            this.coverage = coverage;
            this.performance = performance;
        }

        //bc 성능을 기준으로 내림차순 정렬
        @Override
        public int compareTo(BatteryCharger o) {
            return o.performance - this.performance;
        }
    }

    /**
     * 충전한 양의 합의 최댓값 구하는 메서드
     * @return
     */
    static int getSumOfPerformance() {
        int totalSum = 0, rowA = 1, colA = 1, rowB = 10, colB = 10;
        for (int i = 0; i <= M; i++) { //초기 위치부터 이동 명령어 모두 실행
            int max = 0, index = 0;
            List<Integer> aList = new ArrayList<>(); //A가 위치한 곳의 bc 리스트
            List<Integer> bList = new ArrayList<>(); //B가 위치한 곳의 bc 리스트
            rowA += deltas[moveA[i]][0]; //A가 이동한 y좌표
            colA += deltas[moveA[i]][1]; //A가 이동한 x좌표
            rowB += deltas[moveB[i]][0]; //B가 이동한 y좌표
            colB += deltas[moveB[i]][1]; //B가 이동한 x좌표

            for (BatteryCharger bc : bcs) { //모든 bc에 대해서 A,B와 거리 확인
                if (getDistance(colA, rowA, bc.x, bc.y) <= bc.coverage) //A가 범위안에 있으면 해당 bc 추가
                    aList.add(index);
                if (getDistance(colB, rowB, bc.x, bc.y) <= bc.coverage) //B가 범위안에 있으면 해당 bc 추가
                    bList.add(index);
                index++;
            }

            if (!aList.isEmpty() || !bList.isEmpty()) { //A와 B의 bc리스트가 하나라도 비어있지 않을 때
                if (!aList.isEmpty() && !bList.isEmpty()) { //A와 B의 bc리스트가 둘다 비어있지 않을 때
                    if (aList.get(0) == bList.get(0)) { //충전 최대 성능이 같다면 성능을 나눠써야 하므로 한명은 다른 bc 사용해야지 효율적
                        if (aList.size() >= 2) //A리스트에 2개이상의 원소가 있으면 A의 bc를 교체
                            max = Math.max(bcs[aList.get(1)].performance + bcs[bList.get(0)].performance, max);
                        if (bList.size() >= 2)//B리스트에 2개이상의 원소가 있으면 B의 bc를 교체
                            max = Math.max(bcs[bList.get(1)].performance + bcs[aList.get(0)].performance, max);
                    } else {//서로 다른 bc를 사용하므로 그냥 충전량 더하기
                        max = Math.max(bcs[aList.get(0)].performance + bcs[bList.get(0)].performance, max);
                    }
                }
                if (!aList.isEmpty()) //A만 bc를 가지고 있을 때
                    max = Math.max(bcs[aList.get(0)].performance, max);
                if (!bList.isEmpty()) //B만 bc를 가지고 있을 때
                    max = Math.max(bcs[bList.get(0)].performance, max);
            }
            totalSum += max;
        }
        return totalSum;
    }// end of getSumOfPerformance method;

    /**
     * 거리를 구하는 메서드
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }// end of getDistance method
}// end of Solution class

