//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1179 👎 0


package com.liugs.leetcode.editor.cn;

import com.liugs.leetcode.editor.cn.commonObj.TreeNode;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        private int answer = 0;

        public int maxDepth(TreeNode root) {
            return countFromLeaf(root);
        }

        private void countFromRoot(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                answer = Math.max(answer, depth);
            }
            countFromRoot(root.left, depth + 1);
            countFromRoot(root.right, depth + 1);
        }

        private int countFromLeaf(TreeNode root){
            if (root == null){
                return 0;
            }
            int leftVal = countFromLeaf(root.left);
            int rightVal = countFromLeaf(root.right);
            return Math.max(leftVal,rightVal) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}