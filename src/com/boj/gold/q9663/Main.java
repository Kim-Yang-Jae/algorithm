package com.boj.gold.q9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, cnt;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N];

        getNumOfCase(0);
        System.out.println(cnt);
    }

    static void getNumOfCase(int queenCnt) {
        if(queenCnt == N){
            cnt ++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[queenCnt] = i;
            if(check(queenCnt))
                getNumOfCase(queenCnt + 1);
        }
    }

    static boolean check(int col){
        for (int i = 0; i < col; i++) {
            if(board[col] == board[i]){
                return false;
            }else if(Math.abs(col-i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
