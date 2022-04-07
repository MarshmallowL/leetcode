//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 711 👎 0


package com.liugs.leetcode.editor.cn;

import com.liugs.leetcode.editor.cn.commonObj.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] inorder =new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode node = solution.buildTree(inorder,postorder);
        System.out.println(node.val);
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        }

        private TreeNode build(int[] inorder, int[] postorder, int inorderStart, int inorderEnd,
                               int postOrderStart, int postOrderEnd) {
            if (inorderStart > inorderEnd || postOrderStart > postOrderEnd){
                return null;
            }
            int rootVal = postorder[postOrderEnd];
            TreeNode root = new TreeNode(rootVal);
            int mid = 0;
            while (inorderStart + mid <inorder.length - 1&& inorder[inorderStart + mid] != rootVal) {
                mid++;
            }
            int rightCount = inorderEnd - mid - inorderStart;
            int leftCount = mid;
            root.right = build(inorder, postorder, inorderStart + mid + 1, inorderEnd,
                    postOrderEnd - rightCount, postOrderEnd - 1);
            root.left = build(inorder, postorder, inorderStart, inorderStart + mid - 1,
                    postOrderStart, postOrderStart + leftCount - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}