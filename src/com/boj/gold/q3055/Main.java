package com.boj.gold.q3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * BOJ Q3055 탈출
 * BFS
 */
public class Main {
    static int R, C; //map의 행, map의 열
    static char[][] map; //지형 저장 배열
    static Queue<Coordinate> queue; //bfs에 이용한 큐
    static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; //상하좌우이동을 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        queue = new LinkedList<Coordinate>();
        Coordinate hedgehog = null; //고슴도치를 가장 마지막에 움직이게 하기 위해 따로 고슴도치 저장

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] == '*') //물의 좌표 객체를 큐에 저장
                    queue.add(new Coordinate(r, c, 0, map[r][c]));
                else if(map[r][c] == 'S') //고슴도치 좌표 따로 저장
                    hedgehog = new Coordinate(r, c, 0, map[r][c]);
            }
        }

        queue.add(hedgehog);// 고슴도치 좌표 큐에 저장

        int result = bfs();
        if (result==-1) //결과값이 -1이면 고슴도치가 비버의 굴에 도착하지 못했기 때문에 "KAKTTUS" 출력
            sb.append("KAKTUS");
        else //아니면 결과값 출력
            sb.append(result);

        System.out.println(sb.toString());
        br.close();

    }

    /**
     * 물과 고슴도치의 좌표를 저장하기 위한 클래스
     */
    static class Coordinate{
        int row, col, cnt; //행, 열, 이동 턴수
        char ch; //ch를 통해 물인지 고슴도치 구분

        public Coordinate(int row, int col, int cnt, char ch) {
            super();
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.ch = ch;
        }
    }

    /**
     * 고슴도치가 비버굴에 도착하는 시간을 구하기 위한 메서드
     * @return 비버굴에 도착하면 도착 시간 반환, 도착하지 못하면 -1 반환
     */
    static int bfs() {
        Coordinate coordinate = null;
        boolean isCheck = false; //도착했는지 안했는지 체크
        Loop:
        while (!queue.isEmpty()) { //큐가 빌때까지 반복
            coordinate = queue.poll(); //큐에서 좌표를 꺼냄
            for (int d = 0; d < 4; d++) { //사방탐색 실시
                int tmpR = coordinate.row + deltas[d][0];
                int tmpC = coordinate.col + deltas[d][1];
                if (tmpR >= 0 && tmpR < R && tmpC >= 0 && tmpC < C) {
                    if(map[tmpR][tmpC] == '.') { //이동좌표가 땅이면 이동 표시 후 큐에 넣기
                        map[tmpR][tmpC] = coordinate.ch;
                        queue.add(new Coordinate(tmpR, tmpC, coordinate.cnt + 1, coordinate.ch));
                    }else if(map[tmpR][tmpC] == 'D' && coordinate.ch =='S') { //고슴도치고 이동좌표가 비버면 메서드 종료
                        coordinate.cnt++;
                        isCheck = true;
                        break Loop;
                    }
                }
            }
        }
        if(isCheck)// 비버굴에 도착하면 이동 턴수 반환
            return coordinate.cnt;
        return -1;// 못했으면 -1리턴
    }
}
