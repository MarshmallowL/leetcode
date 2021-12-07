package com.liugs.algorithm;

import java.util.Arrays;

/**
 * @author liugs
 * @createTime 2021/12/7 23:42
 * 计数排序
 */
public class CountSort {
    private static int[] sort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int n = max - min + 1;
        int[] sort = new int[n];
        int len = nums.length;
        for (int num : nums) {
            sort[num - min]++;
        }
        int[] resArray = new int[len];
        int index = 0;
        for (int i = 0, sLen = sort.length; i < sLen; i++) {
            while (sort[i] > 0) {
                resArray[index] = i + min;
                index++;
                sort[i]--;
            }
        }
        return resArray;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{16, 11, 17, 7, 7, 8, 8, 10, 21};
        System.out.println(Arrays.toString(CountSort.sort(nums)));
    }
}
