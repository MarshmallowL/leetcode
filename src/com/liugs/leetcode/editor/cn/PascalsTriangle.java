//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 644 👎 0


package com.liugs.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        System.out.println(solution.generate(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> list1 = Stream.of(1).collect(Collectors.toList());
            List<Integer> list2 = Stream.of(1, 1).collect(Collectors.toList());
            if (numRows == 1) {
                list.add(list1);
            } else if (numRows == 2) {
                list.add(list1);
                list.add(list2);
            } else {
                list.add(list1);
                list.add(list2);
                for (int i = 2; i < numRows; i++) {
                    List<Integer> subList = new ArrayList<>();
                    List<Integer> lastList = list.get(i - 1);
                    subList.add(1);
                    for (int j = 1; j < i; j++) {
                        subList.add(lastList.get(j) + lastList.get(j - 1));
                    }
                    subList.add(1);
                    list.add(subList);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}