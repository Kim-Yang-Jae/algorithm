package com.boj.gold.q1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ Q1987 알파벳
 * DFS, 백트래킹
 */
public class Main {
    static int R, C, max, size;
    static char[][] board;
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static List<Character> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        max = 0;
        board = new char[R][C];
        visited = new ArrayList<>();

        for (int r = 0; r < R; r++) {
            String input = br.readLine();
            for (int c = 0; c < C; c++) {
                board[r][c] = input.charAt(c);
            }
        }

        visit(0, 0, 0);
        System.out.println(max);
    }// end of main method

    /**
     * 보드를 DFS 탐색하는 메서드
     * @param r
     * @param c
     * @param cnt
     */
    static void visit(int r, int c, int cnt) {
        if (visited.contains(board[r][c])) { //이동한 칸의 알파벳이 방문한 적이 있으면 메서드 종료
            max = Math.max(max, cnt); //최댓값 갱신
            return;
        }
        visited.add(board[r][c]); //방문한 알파벳 표시
        for (int d = 0; d < 4; d++) { //사방탐색
            int tmpR = r, tmpC = c;
            tmpR += deltas[d][0];
            tmpC += deltas[d][1];
            if (tmpR >= 0 && tmpR < R && tmpC >= 0 && tmpC < C) //다음 이동할 칸으로 재귀함수를 이용해 이동
                visit(tmpR, tmpC, cnt + 1);
        }
        int index = visited.indexOf(board[r][c]);
        visited.remove(index);

    }// end of visit method
}// end of Main class
