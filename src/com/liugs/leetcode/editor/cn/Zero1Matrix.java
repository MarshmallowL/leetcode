//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
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
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 623 👎 0


package com.liugs.leetcode.editor.cn;

import java.util.*;

public class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();
        int mat[][] = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(solution.updateMatrix(mat)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            Queue<int[]> queue = new LinkedList<>();
            int rowLen = mat.length;
            int colLen = mat[0].length;
            boolean[][] visited = new boolean[rowLen][colLen];
            int[][] dist = new int[rowLen][colLen];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 0) {
                        visited[i][j] = true;
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            while (!queue.isEmpty()) {
                int[] position = queue.poll();
                int row = position[0], col = position[1];
                if (row > 0 && !visited[row - 1][col]) {
                    queue.offer(new int[]{row - 1, col});
                    dist[row - 1][col] = dist[row][col] + 1;
                    visited[row - 1][col] = true;
                }
                if (row < rowLen - 1 && !visited[row + 1][col]) {
                    queue.offer(new int[]{row + 1, col});
                    dist[row + 1][col] = dist[row][col] + 1;
                    visited[row + 1][col] = true;
                }
                if (col > 0 && !visited[row][col - 1]) {
                    queue.offer(new int[]{row, col - 1});
                    dist[row][col - 1] = dist[row][col] + 1;
                    visited[row][col - 1] = true;
                }
                if (col < colLen - 1 && !visited[row][col + 1]) {
                    queue.offer(new int[]{row, col + 1});
                    dist[row][col + 1] = dist[row][col] + 1;
                    visited[row][col + 1] = true;
                }
            }
            return dist;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}