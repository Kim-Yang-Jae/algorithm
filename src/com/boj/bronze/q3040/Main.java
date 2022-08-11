package com.boj.bronze.q3040;

import java.io.*;

/**
 * BOJ Q3040 백설 공주와 일곱 난쟁이
 */
public class Main {
    static int[] dwarfs;
    static int[] sevenDwarfs;
    static int[] selected;
    static boolean isEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dwarfs = new int[9];
        sevenDwarfs = new int[7];
        selected = new int[7];
        isEnd = false;
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }
        findSevenDwarf(0, 0, 0);

        for (int dwarf : sevenDwarfs) {
            bw.write(dwarf + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void findSevenDwarf(int cnt, int index, int sum) {
        if (cnt == 7) {
            if (sum == 100){
                sevenDwarfs = selected;
                isEnd = true;
            }
            return;
        }
        if (index >= 9)
            return;
        if (sum > 100)
            return;
        if(isEnd)
            return;
        selected[cnt] = dwarfs[index];
        findSevenDwarf(cnt + 1, index + 1, sum + dwarfs[index]);
        findSevenDwarf(cnt, index + 1, sum);
    }
}
