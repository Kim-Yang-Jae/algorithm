package com.swea.q1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    static final int Bracket = 0, Brace = 1, Parenthesis = 2, Chevron = 3;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc<=10; tc++) {
            int lenght = Integer.parseInt(br.readLine());
            String input = br.readLine();
            Stack<Integer> stack = new Stack<>();

            for(int i = 0 ; i<lenght; i++) {
                if(stack.isEmpty()) {
                    stack.push(changeBrackets(input.charAt(i)));
                }else if(stack.peek()== changeBrackets(input.charAt(i))) {
                    stack.pop();
                }else {
                    stack.push(changeBrackets(input.charAt(i)));
                }
            }
            if (stack.isEmpty())
                System.out.printf("#%d %d\n",tc, 1);
            else
                System.out.printf("#%d %d\n",tc, 0);
        }
        br.close();
    }

    public static int changeBrackets(char ch) {
        if (ch == '[' || ch ==']')
            return Bracket;
        else if(ch == '{' || ch == '}')
            return Brace;
        else if(ch == '(' || ch == ')')
            return Parenthesis;
        else if(ch == '<' || ch == '>')
            return Chevron;
        else
            return -1;
    }
}

