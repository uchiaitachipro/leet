package com.uchia.leetcode.top100;

import java.util.LinkedList;
import java.util.Stack;

public class IsValid20 {
    // amazon bytedance linkedin
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0 ;i < s.length(); i++){
            Character c = s.charAt(i);
            if ( c== '(' || c == '[' || c == '{'){
                stack.addLast(c);
            } else{
                if (stack.isEmpty()){
                    return false;
                }
                Character last = stack.removeLast();
                if (!(last == '(' && c == ')' || last == '[' && c == ']' || last == '{' && c == '}')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid20 valid20 = new IsValid20();
//        System.out.println("result: " + valid20.isValid("()"));
//
//        System.out.println("result: " + valid20.isValid("()[]{}"));
//
//        System.out.println("result: " + valid20.isValid("([)]"));
//
//        System.out.println("result: " + valid20.isValid("{[]}"));
        System.out.println("result: " + valid20.isValid("]"));
    }
}
