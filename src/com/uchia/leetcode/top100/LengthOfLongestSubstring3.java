package com.uchia.leetcode.top100;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring3 {
    // bytedance amazon facebook
    public int lengthOfLongestSubstring(String s) {
        int end = -1;
        int result = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if (!set.isEmpty()){
                char c = s.charAt(i - 1);
                set.remove(c);
            }
            while (end + 1 < s.length() && !set.contains(s.charAt(end + 1))){
                set.add(s.charAt(end + 1));
                end++;
            }
            result = Math.max(result,end - i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring3 weightII1049 = new LengthOfLongestSubstring3();
        System.out.println("result: " + weightII1049.lengthOfLongestSubstring("abcabcbb"));

        System.out.println("result: " + weightII1049.lengthOfLongestSubstring("bbbbb"));

        System.out.println("result: " + weightII1049.lengthOfLongestSubstring("pwwkew"));

        System.out.println("result: " + weightII1049.lengthOfLongestSubstring(""));
    }
}
