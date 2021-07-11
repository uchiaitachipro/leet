package com.uchia.leetcode.dynamics;

public class ShortestWay1055 {
    // facebook
    public int shortestWay(String source, String target) {
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();

        int ans = 0;
        int start = 0;
        while(start < target.length()){
            int end = start;
            for(char c : sourceArray){
                if (c == targetArray[end]){
                    end++;
                }
                if (end == target.length()){
                    break;
                }
            }
            if (start == end){
                return -1;
            }
            ans++;
            start = end;
        }
        return ans;
    }

    public static void main(String[] args) {
        ShortestWay1055 shortestWay = new ShortestWay1055();
        // 2
        System.out.println("max count: " + shortestWay.shortestWay("abc","abcbc"));

        // -1
        System.out.println("max count: " + shortestWay.shortestWay("abc","acdbc"));

        // 3
        System.out.println("max count: " + shortestWay.shortestWay("xyz","xzyxz"));
    }
}
