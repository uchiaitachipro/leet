package com.uchia.leetcode.top100;

public class ValidPalindrome680 {
    // facebook microsoft google
    public boolean validPalindrome(String s) {
        return _validPalindrome(s, true);
    }

    private boolean _validPalindrome(String s, boolean checkSubString) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return checkSubString && (_validPalindrome(s.substring(start, end), false)
                        || _validPalindrome(s.substring(start + 1, end + 1), false));
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome680 validPalindrome680 = new ValidPalindrome680();

        System.out.println("result: " + validPalindrome680.validPalindrome("aba"));

        System.out.println("result: " + validPalindrome680.validPalindrome("abca"));

        System.out.println("result: " + validPalindrome680.validPalindrome("abc"));
    }
}
