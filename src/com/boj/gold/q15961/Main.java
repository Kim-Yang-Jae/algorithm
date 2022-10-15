package com.boj.gold.q15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int[] conveyorBelt, checkEat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        conveyorBelt = new int[N];
        checkEat = new int[d + 1];

        for (int i = 0; i < N; i++) {
            conveyorBelt[i] = Integer.parseInt(br.readLine());
        }

        int result = getMaxNumOfKind();
        System.out.println(result);
        br.close();
    }

    static int getMaxNumOfKind() {
        int max = 0, kind = 0;

        for (int i = 0; i < k; i++) {
            int num = conveyorBelt[i];
            if (checkEat[num] == 0)
                kind++;
            checkEat[num]++;
        }

        max = kind;

        for (int i = 1; i < N; i++) {
            int changeLeft = conveyorBelt[i - 1];
            int changeRight = conveyorBelt[(i + k - 1) % N];

            checkEat[changeLeft]--;
            if(checkEat[changeLeft] == 0)
                kind--;

            if(checkEat[changeRight] == 0)
                kind++;
            checkEat[changeRight]++;

            max = max <= kind ? checkEat[c] == 0 ? kind + 1 : kind : max;
        }

        return max;
    }
}
