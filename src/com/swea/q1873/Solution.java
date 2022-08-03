package com.swea.q1873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H][W];

            for (int i = 0; i < H; i++) {
                String mapInput = br.readLine();

                for (int j = 0; j < W; j++) {
                    map[i][j] = mapInput.charAt(j);
                }
            }

            int N = Integer.parseInt(br.readLine());
            String command = br.readLine();

            char[] commands = new char[N];

            for (int i = 0; i < N; i++) {
                commands[i] = command.charAt(i);
            }

            calcMapState(tc, map, commands);
        }

        br.close();
    }

    public static void calcMapState(int tc, char[][] map, char[] commands) {
        boolean isComplete = false;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                    int tmpI = i;
                    int tmpJ = j;
                    for (int k = 0; k < commands.length; k++) {
                        if (commands[k] == 'S') {
                            if (map[tmpI][tmpJ] == '^') {
                                for (int l = tmpI - 1; l >= 0; l--) {
                                    if (map[l][tmpJ] == '#')
                                        break;
                                    else if (map[l][tmpJ] == '*') {
                                        map[l][tmpJ] = '.';
                                        break;
                                    } else
                                        continue;
                                }
                            } else if (map[tmpI][tmpJ] == 'v') {
                                for (int l = tmpI + 1; l < map.length; l++) {
                                    if (map[l][tmpJ] == '#')
                                        break;
                                    else if (map[l][tmpJ] == '*') {
                                        map[l][tmpJ] = '.';
                                        break;
                                    } else
                                        continue;
                                }
                            } else if (map[tmpI][tmpJ] == '<') {
                                for (int l = tmpJ - 1; l >= 0; l--) {
                                    if (map[tmpI][l] == '#')
                                        break;
                                    else if (map[tmpI][l] == '*') {
                                        map[tmpI][l] = '.';
                                        break;
                                    } else
                                        continue;
                                }
                            } else if (map[tmpI][tmpJ] == '>') {
                                for (int l = tmpJ + 1; l < map[0].length; l++) {
                                    if (map[tmpI][l] == '#')
                                        break;
                                    else if (map[tmpI][l] == '*') {
                                        map[tmpI][l] = '.';
                                        break;
                                    } else
                                        continue;
                                }
                            }
                        } else if (commands[k] == 'U') {
                            map[tmpI][tmpJ] = '^';
                            if (tmpI - 1 >= 0 && map[tmpI - 1][tmpJ] == '.') {
                                tmpI = tmpI - 1;
                                map[tmpI + 1][tmpJ] = '.';
                                map[tmpI][tmpJ] = '^';
                            }
                        } else if (commands[k] == 'D') {
                            map[tmpI][tmpJ] = 'v';
                            if (tmpI + 1 < map.length && map[tmpI + 1][tmpJ] == '.') {
                                tmpI = tmpI + 1;
                                map[tmpI - 1][tmpJ] = '.';
                                map[tmpI][tmpJ] = 'v';
                            }
                        } else if (commands[k] == 'L') {
                            map[tmpI][tmpJ] = '<';
                            if (tmpJ - 1 >= 0 && map[tmpI][tmpJ - 1] == '.') {
                                tmpJ = tmpJ - 1;
                                map[tmpI][tmpJ + 1] = '.';
                                map[tmpI][tmpJ] = '<';
                            }

                        } else if (commands[k] == 'R') {
                            map[tmpI][tmpJ] = '>';
                            if (tmpJ + 1 < map[0].length && map[tmpI][tmpJ + 1] == '.') {
                                tmpJ = tmpJ + 1;
                                map[tmpI][tmpJ - 1] = '.';
                                map[tmpI][tmpJ] = '>';
                            }
                        }
                    }
                    isComplete = true;
                }
                if (isComplete)
                    break;
            }
            if (isComplete)
                break;
        }

        printMap(tc, map);
    }

    public static void printMap(int tc, char[][] map) {
        System.out.printf("#%d ", tc);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
