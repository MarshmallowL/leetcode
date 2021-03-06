//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 1925 👎 0


package com.liugs.leetcode.editor.cn;


public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            for (int i = 1, len = strs.length; i < len; i++) {
                String curr = strs[i];
                int arrayLen = Math.min(prefix.length(), curr.length());
                int index = 0;
                while (index < arrayLen && prefix.charAt(index) == curr.charAt(index)) {
                    index++;
                }
                prefix = prefix.substring(0, index);
            }
            return prefix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}