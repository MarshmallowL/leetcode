  //给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。 
//
// h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引
//用了至少 h 次。且其余的 n - h 篇论文每篇被引用次数 不超过 h 次。 
//
// 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。 
//
// 提示：如果 h 有多种可能的值，h 指数 是其中最大的那个。 
//
// 
//
// 示例 1： 
//
// 
//输入：citations = [3,0,6,1,5]
//输出：3 
//解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
//     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。 
//
// 示例 2： 
//
// 
//输入：citations = [1,3,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == citations.length 
// 1 <= n <= 5000 
// 0 <= citations[i] <= 1000 
// 
// Related Topics 数组 计数排序 排序 👍 230 👎 0

  
  package com.liugs.leetcode.editor.cn;
  public class HIndex{
      public static void main(String[] args) {
           Solution solution = new HIndex().new Solution();
           int[] nums = new int[]{1,3,1};
          System.out.println(solution.hIndex(nums));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        //计数排序 n = citations.length; n >= h;
        int n = citations.length,total = 0;
        int[] sortedArray = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n){
                sortedArray[n]++;
            }else{
                sortedArray[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            total += sortedArray[i];
            if (total >= i){
                return i;
            }
        }
        return 0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }