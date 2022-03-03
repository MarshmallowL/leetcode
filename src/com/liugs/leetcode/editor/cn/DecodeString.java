//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// s 由小写英文字母、数字和方括号 '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为 [1, 300] 
// 
// Related Topics 栈 递归 字符串 👍 1052 👎 0


package com.liugs.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        String s = "100[leetcode]";
        System.out.println(solution.decodeString(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            List<Character> tmpList = new ArrayList<>();
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] == '[') {
                    while (stack.peek() != ']') {
                        tmpList.add(stack.pop());
                    }
                    stack.pop();
                    int repeatNum = Character.isDigit(chars[i-1]) ? 0 : 1;
                    int multiple = 1;
                    while (i > 0 && Character.isDigit(chars[i - 1])) {
                        repeatNum += Character.getNumericValue(chars[i - 1]) * multiple;
                        multiple *= 10;
                        i--;
                    }
                    for (int j = 0; j < repeatNum; j++) {
                        for (int k = tmpList.size() - 1; k >= 0; k--) {
                            stack.push(tmpList.get(k));
                        }
                    }
                    tmpList.clear();
                } else {
                    stack.push(chars[i]);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}