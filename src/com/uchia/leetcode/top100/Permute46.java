package com.uchia.leetcode.top100;

import com.uchia.leetcode.Utils;

import java.util.LinkedList;
import java.util.List;

public class Permute46 {

    // bytedance amazon huawei
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> trace = new LinkedList<>();
        backtrace(nums,trace,result);
        return result;
    }

    private void backtrace(int[] nums,List<Integer> trace,List<List<Integer>> result){
        if (trace.size() == nums.length){
            result.add(new LinkedList<>(trace));
            return;
        }

        for (int i = 0; i <nums.length; i++){
            if (trace.contains(nums[i])){
                continue;
            }
            trace.add(nums[i]);
            backtrace(nums,trace,result);
            trace.remove(trace.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permute46 permute46 = new Permute46();
        Utils.printList2D(permute46.permute(new int[]{
               1
        }));
    }
}
