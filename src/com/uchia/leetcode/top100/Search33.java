package com.uchia.leetcode.top100;

public class Search33 {
    // amazon microsoft linkedin
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[0]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Search33 search33 = new Search33();

        System.out.println("result: " + search33.search(
                new int[]{
                        4,5,6,7,0,1,2
                },
                0
        ));

        System.out.println("result: " + search33.search(
                new int[]{
                        4,5,6,7,0,1,2
                },
                3
        ));

        System.out.println("result: " + search33.search(
                new int[]{
                       3,1
                },
                1
        ));
    }

}
