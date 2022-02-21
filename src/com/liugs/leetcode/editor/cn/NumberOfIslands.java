//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1515 👎 0


package com.liugs.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        char[][] grid = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(solution.numIslands(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            return numIslandsByDFS(grid);
        }

        private int numIslandsByDFS(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0, jLen = grid[i].length; j < jLen; j++) {
                    if (grid[i][j] == '0') {
                        continue;
                    }
                    grid[i][j] = '0';
                    count++;
                    DFS(i, j, grid);
                }
            }
            return count;
        }

        private void DFS(int i, int j, char[][] grid) {
            if (i > 0 && grid[i - 1][j] == '1') {
                grid[i - 1][j] = '0';
                DFS(i - 1, j, grid);
            }
            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                grid[i + 1][j] = '0';
                DFS(i + 1, j, grid);
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = '0';
                DFS(i, j - 1, grid);
            }
            if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                grid[i][j + 1] = '0';
                DFS(i, j + 1, grid);
            }
        }

        private int numIslandsByBFS(char[][] grid) {
            int count = 0;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0, jLen = grid[i].length; j < jLen; j++) {
                    if (grid[i][j] == '0') {
                        continue;
                    }
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';
                    count++;
                    BFS(queue, grid);
                }
            }
            return count;
        }

        private void BFS(Queue<int[]> queue, char[][] grid) {
            while (!queue.isEmpty()) {
                int[] position = queue.poll();
                int i = position[0], j = position[1];
                if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                    grid[i][j + 1] = '0';
                    queue.offer(new int[]{i, j + 1});
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    grid[i][j - 1] = '0';
                    queue.offer(new int[]{i, j - 1});
                }
                if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                    grid[i + 1][j] = '0';
                    queue.offer(new int[]{i + 1, j});
                }
                if (i > 0 && grid[i - 1][j] == '1') {
                    grid[i - 1][j] = '0';
                    queue.offer(new int[]{i - 1, j});
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}