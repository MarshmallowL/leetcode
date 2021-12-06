  //给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。 
//
// 找到所有出现两次的元素。 
//
// 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？ 
//
// 示例： 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[2,3]
// 
// Related Topics 数组 哈希表 👍 453 👎 0

  
  package com.liugs.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.regex.Pattern;

  public class FindAllDuplicatesInAnArray{
      public static void main(String[] args) {
           Solution solution = new FindAllDuplicatesInAnArray().new Solution();
           int[] nums = new int[]{10,2,5,10,9,1,1,4,3,7};
           solution.findDuplicates(nums);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = (nums[i] - 1)%n;
            nums[index] += n;
            if (nums[index] > 2*n){
                resultList.add(index + 1);
            }
        }
        return resultList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }