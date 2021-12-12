//包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值
//求平均，如果周围的单元格不足八个，则尽可能多的利用它们。 
//
// 示例 1: 
//
// 
//输入:
//[[1,1,1],
// [1,0,1],
// [1,1,1]]
//输出:
//[[0, 0, 0],
// [0, 0, 0],
// [0, 0, 0]]
//解释:
//对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
//对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
//对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
// 
//
// 注意: 
//
// 
// 给定矩阵中的整数范围为 [0, 255]。 
// 矩阵的长和宽的范围均为 [1, 150]。 
// 
// Related Topics 数组 矩阵 👍 87 👎 0


package com.liugs.leetcode.editor.cn;

import java.util.Arrays;

public class ImageSmoother {
    public static void main(String[] args) {
        Solution solution = new ImageSmoother().new Solution();
        int[][] img = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(solution.imageSmoother(img)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] imageSmoother(int[][] img) {
            int rowLen = img.length;
            int columnLen = img[0].length;
            int[][] res = new int[rowLen][columnLen];
            for (int i = 0; i < rowLen; ++i) {
                for (int j = 0; j < columnLen; ++j) {
                    int count = 0;
                    for (int k = i - 1; k <= i + 1; ++k) {
                        for (int l = j - 1; l <= j + 1; ++l) {
                            if (k >= 0 && k < rowLen && l >= 0 && l < columnLen) {
                                res[i][j] = res[i][j] + img[k][l];
                                count++;
                            }
                        }
                    }
                    res[i][j] /= count;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}