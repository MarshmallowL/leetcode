  //实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1191 👎 0

  
  package com.liugs.leetcode.editor.cn;
  public class ImplementStrstr{
      public static void main(String[] args) {
           Solution solution = new ImplementStrstr().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)){
            return 0;
        }
        return search(haystack,needle);
    }

          public int search(String s,String p){
              char[] S = s.toCharArray();
              char[] P = p.toCharArray();
              int[] next = getNextArray(P);
              int i = 0,j = 0;
              while (j < S.length){
                  if (S[j] == P[i]){
                      i++;j++;
                  }else if (i != 0){
                      i = next[i - 1];
                  }else{
                      j++;
                  }
                  if (i == P.length){
                      return j - i;
                  }
              }
              return -1;
          }

          private int[] getNextArray(char[] p){
              int pLen = p.length;
              int[] next = new int[pLen+1];
              int i = 1,now = 0;
              while (i < pLen){
                  if (p[i] == p[now]){
                      now++;
                      next[i] = now;
                      i++;
                  }else if (now != 0){
                      now = next[now -1];
                  }else {
                      i++;
                      next[i] = now;
                  }
              }
              return next;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }