//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4478 👎 0


package com.liugs.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("ac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0, len = s.length(); i < len; i++) {
                for (int j = len; j > i; j--) {
                    String substr = s.substring(i, j);
                    if (isPalindrome(substr)) {
                        res = res.length() > substr.length() ? res : substr;
                        break;
                    }
                }
            }
            return res;

        }

        private boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left <= right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            return left > right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}