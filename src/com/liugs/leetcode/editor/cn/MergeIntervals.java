  //以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1225 👎 0

  
  package com.liugs.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.Comparator;
  import java.util.List;

  public class MergeIntervals{
      public static void main(String[] args) {
           Solution solution = new MergeIntervals().new Solution();
           int[][] intervals = new int[][]{{1,4},{4,5}};
          System.out.println(Arrays.deepToString(solution.merge(intervals)));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals){
            int len = list.size();
            if (len == 0 || list.get(len -1)[1] < interval[0]){
                list.add(interval);
            }else if (list.get(len - 1)[1] >= interval[0]){
                list.get(len - 1)[1] = Math.max(list.get(len -1)[1],interval[1]);
            }
        }
        return list.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }