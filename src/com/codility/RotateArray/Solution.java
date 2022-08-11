package com.codility.RotateArray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 8, 9, 7, 6};
        System.out.println(Arrays.toString(solution(arr,3)));
    }

    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 11
        if (A.length == K)
            return A;

        int[] result = new int[A.length];
        for (int cnt = 0; cnt < K; cnt++) {
            result = new int[A.length];
            int index = 0;
            result[index] = A[A.length - 1];
            for (int i = 0; i < A.length - 1; i++) {
                result[i+1] = A[i];
            }
            A = result.clone();
        }
        return result;
    }

}
