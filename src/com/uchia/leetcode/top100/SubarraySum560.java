package com.uchia.leetcode.top100;

import java.util.HashMap;
import java.util.HashSet;

public class SubarraySum560 {

    //facebook microsoft amazon
    public int subarraySum(int[] nums, int k) {
        int count = 0,sum = 0;
        HashMap<Integer,Integer> set = new HashMap<>();
        set.put(0,1);
        for(int i = 0;i < nums.length; i++){
            sum += nums[i];
            int remain = sum - k;
            if (set.containsKey(remain)){
                count += set.get(remain);
            }
            set.put(sum,set.getOrDefault(sum,0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySum560 sum560 = new SubarraySum560();
        System.out.println(sum560.subarraySum(new int[]{
                1,-1,0
        },0));
    }

}
