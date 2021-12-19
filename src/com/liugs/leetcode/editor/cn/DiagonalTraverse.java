//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
// Related Topics 数组 矩阵 模拟 👍 253 👎 0


package com.liugs.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(solution.findDiagonalOrder(mat)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int i = 0, j = 0;
            int rowLen = mat.length;
            int columnLen = mat[0].length;
            List<Integer> list = new ArrayList<>();
            boolean rightFlag = true;
            for (int k = 0; k < rowLen + columnLen - 1; k++) {
                if (rightFlag) {
                   while (i >= 0 && j < columnLen){
                       list.add(mat[i][j]);
                       i--;j++;
                   }
                   if (j >= columnLen){
                       j = columnLen - 1;
                       i = i+2;
                   }else {
                       i=0;
                   }
                   rightFlag = false;
                } else {
                    while (j >= 0&& i < rowLen){
                        list.add(mat[i][j]);
                        i++;j--;
                    }
                    if (i >= rowLen){
                        j = j+2;
                        i = rowLen - 1;
                    }else {
                        j = 0;
                    }
                    rightFlag = true;
                }
            }
            return list.stream().mapToInt(x -> x).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}