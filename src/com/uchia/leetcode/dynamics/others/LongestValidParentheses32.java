package com.uchia.leetcode.dynamics.others;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses32 {
    // bytedance amazon huawei facebook meituan
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        char[] array = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        stack.add(-1);
        for(int i = 0; i < array.length;i++){
            if(array[i] == '('){
                stack.push(i);
            } else{
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                } else {
                    maxLength = Math.max(i - stack.peek(),maxLength);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestValidParentheses32 parentheses32 = new LongestValidParentheses32();

        // 2
        System.out.println("max sub String Len: " + parentheses32.longestValidParentheses("(()"));

        // 4
        System.out.println("max sub String Len: " + parentheses32.longestValidParentheses(")()())"));
    }
}
