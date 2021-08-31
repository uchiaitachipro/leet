package com.uchia.leetcode.top100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum15 {
    // bytedance amazon facebook
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return new LinkedList<>();
        }
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> otherSum = _twosum(nums, i + 1, -nums[i]);

            if (otherSum.isEmpty()) {
                continue;
            }

            for (List<Integer> twoSums : otherSum) {
                twoSums.add(nums[i]);
                result.add(twoSums);
            }

            while (i + 1 < nums.length - 2 && nums[i + 1] == nums[i]) {
                i++;
            }

        }

        return result;
    }

    private List<List<Integer>> _twosum(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;
        List<List<Integer>> result = new LinkedList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
                while (left < right && nums[left - 1] == nums[left]) {
                    left++;
                }
            } else if (sum > target) {
                right--;
                while (right > left && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else {
                List<Integer> pair = new LinkedList<>();
                pair.add(nums[left]);
                pair.add(nums[right]);
                result.add(pair);

                left++;
                while (left < right && nums[left - 1] == nums[left]) {
                    left++;
                }

                right--;
                while (right > left && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ThreeSum15 sum15 = new ThreeSum15();

        System.out.println("result: " + Arrays.toString(sum15.threeSum(new int[]{
                        -1, 0, 1, 2, -1, -4
                }).toArray())
        );
    }

}
