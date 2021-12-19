//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 哈希表 矩阵 👍 42 👎 0


package com.liugs.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> columnSet = new HashSet<>();
            for (int i = 0, rowLen = matrix.length; i < rowLen; i++) {
                for (int j = 0, columnLen = matrix[0].length; j < columnLen; j++) {
                    if (matrix[i][j] == 0) {
                        rowSet.add(i);
                        columnSet.add(j);
                    }
                }
            }
            for (int i = 0, rowLen = matrix.length; i < rowLen; i++) {
                for (int j = 0, columnLen = matrix[0].length; j < columnLen; j++) {
                    if (rowSet.contains(i) || columnSet.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}