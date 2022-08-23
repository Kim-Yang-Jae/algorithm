package com.boj.silver.q7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  BOJ Q7568 덩치
 */
public class Main {
    static List<People> peopleList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        peopleList = new ArrayList<>();
        for (int cnt = 0; cnt < N; cnt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            peopleList.add(new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (People people : peopleList) {
            getRank(people);
            sb.append(people.rank + 1).append(" ");
        }

        System.out.println(sb.toString());
    }// end of main method

    /**
     * 사람의 키와 몸무게 덩치 등수를 저장하는 클래스
     */
    static class People {
        int height, weight, rank = 0;

        public People(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }// end of People class

    /**
     * 덩치와 몸무게를 비교하면서 덩치 등수를 구하는 메서드
     * @param people
     */
    static void getRank(People people) {
        for (int i = 0; i < peopleList.size(); i++) {
            boolean isTall = false, isHeavy = false;
            if (!people.equals(peopleList.get(i))) { // 현재 People 객체와 비교하는 객체가 같은지 비교
                isTall = people.height < peopleList.get(i).height; // 현재 People 객체의 키가 비교하는 객체의 키보다 작으면 true
                isHeavy = people.weight < peopleList.get(i).weight; // 현재 People 객체의 몸무게가 비교하는 객체의 몸무게 보다 작으면 true
                if(isTall && isHeavy) //둘다 트루면 덩치등수 더하기
                    people.rank ++;
            }
        }
    }// end of getRank method
}// end of Main method
