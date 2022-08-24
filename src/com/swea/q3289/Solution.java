package com.swea.q3289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA Q3289 서로소 집합
 */
public class Solution {
    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            make();

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                if(n == 0) {
                    union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                }else {
                    int xRoot = find(Integer.parseInt(st.nextToken()));
                    int yRoot = find(Integer.parseInt(st.nextToken()));
                    if(xRoot == yRoot) {
                        sb.append(1);
                        continue;
                    }
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void make() {
        parents = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
    }

    static int find(int a) {
        if (parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot)
            return false;

        parents[bRoot] = aRoot;
        return true;
    }
}
