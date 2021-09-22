package com.uchia.leetcode.top100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MinRemoveToMakeValid1249 {
    // facebook amazon apple
    public String minRemoveToMakeValid(String s) {
        Set<Integer> removeIndex = new HashSet<>();
        LinkedList<Integer> leftStack= new LinkedList<>();

        for (int i = 0; i < s.length(); i++){
            char c= s.charAt(i);
            if (c == '('){
                leftStack.addLast(i);
            } else if (c == ')'){
                if (!leftStack.isEmpty()){
                    leftStack.removeLast();
                } else{
                    removeIndex.add(i);
                }
            }
        }

        while (!leftStack.isEmpty()){
            removeIndex.add(leftStack.removeLast());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ;i < s.length(); i++){
            if (!removeIndex.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinRemoveToMakeValid1249 valid1249 = new MinRemoveToMakeValid1249();
        System.out.println("result: " + valid1249.minRemoveToMakeValid("lee(t(c)o)de)"));

        System.out.println("result: " + valid1249.minRemoveToMakeValid("a)b(c)d"));
        System.out.println("result: " + valid1249.minRemoveToMakeValid("))(("));
        System.out.println("result: " + valid1249.minRemoveToMakeValid("(a(b(c)d)"));
    }
}
