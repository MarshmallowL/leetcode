  //给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 哈希表 👍 383 👎 0

  
  package com.liugs.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.HashMap;
  import java.util.List;
  import java.util.Map;

  public class DegreeOfAnArray{
      public static void main(String[] args) {
           Solution solution = new DegreeOfAnArray().new Solution();
           int[] nums = new int[]{1,2,2,3,1};
          System.out.println(solution.findShortestSubArray(nums));;
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findShortestSubArray(int[] nums) {
        int du = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
           map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (int num:map.values()){
           if (num > du){
               du = num;
           }
        }
        int length = 50001;
        Map<Integer, List<Integer>> duMap = new HashMap<>();
        for (int i = 0,len = nums.length; i < len; i++){
            int num = nums[i];
            if (map.get(num) == du){
                List<Integer> positionList = duMap.computeIfAbsent(num,k -> new ArrayList<>());
                positionList.add(i);
            }
        }

        for (List<Integer> list:duMap.values()){
            int tmpLength = list.get(list.size() - 1) - list.get(0);
            if (length > tmpLength){
                length = tmpLength;
            }
        }

        return length + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }