  //给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。 
//
// 不占用额外内存空间能否做到？ 
//
// 
//
// 示例 1: 
//
// 
//给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 
//给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
//
// 注意：本题与主站 48 题相同：https://leetcode-cn.com/problems/rotate-image/ 
// Related Topics 数组 数学 矩阵 👍 202 👎 0

  
  package com.liugs.leetcode.editor.cn;

  import java.util.Arrays;

  public class RotateMatrixLcci{
      public static void main(String[] args) {
           Solution solution = new RotateMatrixLcci().new Solution();
           int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
           solution.rotate(matrix);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < (N + 1)/2; j++) {
                swap(matrix, i, j, j, N - 1 - i);
                swap(matrix,i,j,N-1-i,N-1-j);
                swap(matrix,i,j,N-1-j,i);
            }
        }
        System.out.println(Arrays.deepToString(matrix));

    }

    private void swap(int[][] matrix,int x1,int y1,int x2,int y2){
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }