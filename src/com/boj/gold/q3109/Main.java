package com.boj.gold.q3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ Q3109 빵집
 * DFS
 */
public class Main {
    static int R, C, count;
    static boolean isCheck;
    static char[][] map;
    static int[][] deltas = {{-1, 1}, {0, 1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        count = 0;
        isCheck = false;
        map = new char[R][C];

        for (int r = 0; r < R; r++) {
            String input = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c);
            }
        }
        for (int r = 0; r < R; r++) {
            isCheck = false;
            installPipe(r,0);
        }
        System.out.println(count);
    }// end of main method

    /**
     * 가스관을 연결하는 메서드
     * @param row
     * @param col
     */
    static void installPipe(int row, int col) {
        if (col == C-1) { //마지막 열에 도달하면 파이프 하나가 연결되므로 메서드 종료
            isCheck = true;
            count++; //파이프 개수 +1
            return;
        }
        for (int d = 0; d < 3; d++) { //오른쪽 위, 오른쪽, 오른쪽 아래 탐색
            int tmpR = row, tmpC = col;
            tmpR += deltas[d][0];
            tmpC += deltas[d][1];
            if (tmpR >= 0 && tmpR < R && tmpC <= C && map[tmpR][tmpC] == '.') { //.인곳만 통과 가능
                map[row][col] = '-';
                installPipe(tmpR, tmpC); //재귀함수를 통해 dfs 수행
                if(isCheck)
                    return;
            }
        }
    }// end of installPipe method;
}// end of Main class
