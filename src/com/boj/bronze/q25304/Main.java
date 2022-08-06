package com.boj.bronze.q25304;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int totalPrice = Integer.parseInt(input);
        input = br.readLine();
        int numOfGoods = Integer.parseInt(input);
        int sum = 0;
        for (int i = 0; i < numOfGoods; i++) {
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int price = Integer.parseInt(st.nextToken());
            int quantity = Integer.parseInt(st.nextToken());
            sum += price * quantity;
        }
        if(totalPrice == sum)
            bw.write("Yes");
        else
            bw.write("No");

        bw.flush();
        bw.close();
        br.close();
    }
}
