//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：24
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3]
//输出：-6
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10⁴ 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics 数组 数学 排序 👍 334 👎 0


package com.liugs.leetcode.editor.cn;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfThreeNumbers().new Solution();
        solution.maximumProduct(new int[]{1,2,3,4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
      /*
            思路1
            1.三个数都是正数，取最大三个数的积
            2.两个正数，取两个正数和一个最大负数的积
            3.一个正数，取两个最小负数（绝对值）和该正数的积
            4.零个正数，取最大三个负数的积。
            思路2
            上述中的2和4其实也是取三个最大的数，因此总结下来只要取三个最大值和两个最小值，
            分别算乘积后取最大值即可
         */
    class Solution {
        public int maximumProduct(int[] nums) {
            int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE,
                    d = Integer.MAX_VALUE, e = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num > a) {
                    c = b;
                    b = a;
                    a = num;
                } else if (b < num) {
                    c = b;
                    b = num;
                } else if (c < num) {
                    c = num;
                }
                if (d > num) {
                    e = d;
                    d = num;
                } else if (e > num) {
                    e = num;
                }
            }
            return Math.max(a * b * c, a * d * e);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}