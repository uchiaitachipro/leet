package com.uchia.leetcode;

import java.util.Arrays;

public class Utils {
    public static void printArrays(int[][] arrays){
        Arrays.stream(arrays).map(p -> Arrays.toString(p)).forEach(p ->{
            System.out.print(p + " ");
        });
        System.out.println();
    }
}
