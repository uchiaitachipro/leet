package com.uchia.leetcode.top100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis22 {

    /**
     * 一开始做的时候初始值是1，没有办法限制）()这种情况
     * @param n
     * @return
     */
    // bytedance facebook microsoft
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new LinkedList<>();
        backtrace(n, 0, 0, sb, result);
        return result;
    }

    private void backtrace(int n, int open, int close, StringBuilder sb, List<String> result) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backtrace(n, open + 1, close, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrace(n, open, close + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        GenerateParenthesis22 parenthesis22 = new GenerateParenthesis22();
        System.out.println(Arrays.toString(parenthesis22.generateParenthesis(1).toArray()));
    }

}
