package com.jungol.q1828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  JUNGOL Q1828 냉장고
 *  N개의 화학물질 각각 최저보관온도 최고보관온도 보유
 *  화학물질을 모두 보관하기 위해서 냉장고 필요
 *  가장 적은 수의 냉장고를 가지는 경우
 */
public class Main {
    static int N;
    static Chemical[] chemicals;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        chemicals = new Chemical[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            chemicals[i] = new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(getMinNumOfRefrigerator());

    }// end of main method

    /**
     * 화학물질의 최저 보관 온도, 최고보관온도를 저장하기 위한 클래스
     */
    static class Chemical implements Comparable<Chemical>{
        int minimum, maximum;

        public Chemical(int minimum, int maximum) {
            this.minimum = minimum;
            this.maximum = maximum;
        }

        // 최고온도를 기준으로 화학물질 오름차순 정렬
        @Override
        public int compareTo(Chemical o) {
            if(this.maximum == o.maximum) //최고온도가 같다면 최저온도 기준으로 화학물질 오름차순 정렬
                return Integer.compare(this.minimum, o.minimum);
            return Integer.compare(this.maximum, o.maximum);
        }
    }// end of Chemical class

    /**
     * 최소 냉장고수를 구하는 메서드
     * @return 최소 냉장고 수
     */
    static int getMinNumOfRefrigerator(){
        int count = 1;
        // 최고 보관온도를 기준으로 오름차순 정렬
        Arrays.sort(chemicals);
        //정렬된 배열의 첫번째 화학물질의 최고 보관온도를 냉장고 최고 온도로 설정
        int maxDegree = chemicals[0].maximum;

        for (int i = 1; i < N; i++) {
            //화학물질의 최저온도가 냉장고의 최고온도를 넘으면 새로운 냉장고 추가
            if(maxDegree < chemicals[i].minimum){
                maxDegree = chemicals[i].maximum;
                count++;
            }
        }
        return count;
    }// end of getMinNumOfRefrigerator method
}//end of Main class
