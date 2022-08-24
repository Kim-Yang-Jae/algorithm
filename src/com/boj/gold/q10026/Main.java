package com.boj.gold.q10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  BOJ Q10026 적록색약
 */
public class Main {
    static int N; //그림의 크기
    static char[][] painting, changePainting; //그림을 저장하는 배열, 적록색약이 보는 그림을 저장하는 배열
    static int[][] deltas = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; //사방탐색을 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        painting = new char[N][N];
        changePainting = new char[N][N];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                char ch = str.charAt(c);
                painting[r][c] = ch;
                if (ch == 'G') { //적록색맹이 보는 그림은 녹색을 빨강으로 바꿔줌
                    changePainting[r][c] = 'R';
                    continue;
                }
                changePainting[r][c] = ch;
            }
        }

        int normalCnt = 0; //일반인 구역 수
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (painting[r][c] != 'X') { //이미 방문한 곳이 아니면 dfs 시작
                    dfs(r, c, painting[r][c], painting);
                    normalCnt++;//구역 수 +1
                }
            }
        }

        int blindnessCnt = 0; //적록색맹 구역 수
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (changePainting[r][c] != 'X') { //이미 방문한 곳이 아니면 dfs 시작
                    dfs(r, c, changePainting[r][c], changePainting);
                    blindnessCnt++; //구역 수 +1
                }
            }
        }
        sb.append(normalCnt).append(" ").append(blindnessCnt);
        System.out.println(sb.toString());
    }

    /**
     * dfs를 통하여 구역을 탐색하는 메서드
     * @param row 탐색 시작 행
     * @param col 탐색 시작 열
     * @param color 찾기를 원하는 구역의 색
     * @param copy 그림을 저장한 배열
     */
    static void dfs(int row, int col, char color, char[][] copy) {
        copy[row][col] = 'X'; //방문 표시
        for (int d = 0; d < 4; d++) {
            int tmpR = row + deltas[d][0];
            int tmpC = col + deltas[d][1];
            if (tmpR >= 0 && tmpR < N && tmpC >= 0 && tmpC < N && copy[tmpR][tmpC] == color) //그림의 범위를 벗어나지 않으면 다음 탐색 시작
                dfs(tmpR,tmpC,copy[tmpR][tmpC],copy);
        }
    }
}

