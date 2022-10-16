package com.swea.q3238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static long n, r;
    static int p;
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = null;
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();

            n = Long.parseLong(st.nextToken());
            r = Long.parseLong(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            factorial = new long[p + 1];

            factorial[0] = 1;
            for (int i = 1; i <= p; i++)
                factorial[i] = (factorial[i - 1] * i) % p;

            sb.append("#").append(tc).append(" ").append(nCr(n, r, p));
            System.out.println(sb.toString());
        }
        br.close();
    }

    static long nCr(long n, long r, int p) {
        if (n == 0 || n == r) return 1L;
        else if (r == 1 || r == n - 1) return n % p;

        long result = 1L;

        if (n < p) {
            result *= factorial[(int) n];
            result %= p;
            result *= littleTheorem(factorial[(int) n - (int) r], p - 2);
            result %= p;
            result *= littleTheorem(factorial[(int) r], p - 2);
            result %= p;
        } else {
            while (true) {
                if (n <= 0 && r <= 0) break;

                long denominator = n % p;
                long exponent = r % p;

                if (denominator < exponent) {
                    result = 0;
                    break;
                }

                result *= factorial[(int) denominator];
                result %= p;
                result *= littleTheorem(factorial[(int) denominator - (int) exponent], p - 2);
                result %= p;
                result *= littleTheorem(factorial[(int) exponent], p - 2);
                result %= p;

                n = n / p;
                r = r / p;
            }
        }

        return result;
    }

    static long littleTheorem(long denominator, long exponent) {
        if (exponent == 0) return 1;
        else if (exponent == 1) return denominator;

        if (exponent % 2 == 0) {
            long num = littleTheorem(denominator, exponent / 2);
            return (num * num) % p;
        } else {
            long num = littleTheorem(denominator, exponent - 1);
            return (num * denominator) % p;
        }
    }
}
