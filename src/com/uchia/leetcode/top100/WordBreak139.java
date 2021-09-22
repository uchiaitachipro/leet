package com.uchia.leetcode.top100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak139 {

    // facebook amazon bytedance
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> set = new HashSet<>(wordDict);

        for (int i = 1; i <= s.length(); i++){
            dp[i] = set.contains(s.substring(0,i));
            if (dp[i]){
                continue;
            }
            for (int j = 1; j < i; j++){
                dp[i] |= (dp[j] && set.contains(s.substring(j,i)));
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak139 break139 = new WordBreak139();
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println("result: " + break139.wordBreak("leetcode", wordDict));

        System.out.println("result: " + break139.wordBreak("applepenapple", Arrays.asList("apple", "pen")));


        System.out.println("result: " + break139.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
