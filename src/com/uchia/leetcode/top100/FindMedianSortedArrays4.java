package com.uchia.leetcode.top100;

public class FindMedianSortedArrays4 {
    // bytedance amazon goldman
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 1) {
            return findTheKNum(nums1, nums2, length / 2 + 1);
        } else {
            int midIndex1 = length / 2 - 1, midIndex2 = length / 2;
            return (findTheKNum(nums1, nums2, midIndex1 + 1) + findTheKNum(nums1, nums2, midIndex2 + 1)) / 2.0;
        }
    }

    private int findTheKNum(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            if (index1 >= nums1.length) {
                return nums2[index2 + k - 1];
            }

            if (index2 >= nums2.length) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half,length1) - 1;
            int newIndex2 = Math.min(index2 + half,length2) - 1;
            if (nums1[newIndex1] <= nums2[newIndex2]){
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else{
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }

    }

    public static void main(String[] args) {
        FindMedianSortedArrays4 sortedArrays4 = new FindMedianSortedArrays4();
        System.out.println("middle num: " + sortedArrays4.findMedianSortedArrays(
                new int[]{1,3},
                new int[]{2}
        ));
    }
}
