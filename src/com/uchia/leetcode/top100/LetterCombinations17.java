package com.uchia.leetcode.top100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations17 {
    private char[][] alphabet = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    // amazon microsoft facebook
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits.isEmpty()){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        backtrace(digits.toCharArray(), 0, sb, result);
        return result;
    }

    private void backtrace(char[] digits, int start, StringBuilder sb, List<String> result) {
        if (sb.length() == digits.length) {
            result.add(sb.toString());
            return;
        }

        int numberIndexes = convertToIndex(digits[start]);
        char[] choices = alphabet[numberIndexes - 1];

        for (int i = 0; i < choices.length; i++) {

            sb.append(choices[i]);
            backtrace(digits, start + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


    private int convertToIndex(char c) {
        return c - '0' - 1;
    }

    public static void main(String[] args) {
        LetterCombinations17 combinations17 = new LetterCombinations17();
        System.out.println(Arrays.toString(combinations17.letterCombinations("").toArray()));
    }
}
