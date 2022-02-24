//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1277 👎 0


package com.liugs.leetcode.editor.cn;

import com.liugs.algorithm.pedigree.PedigreeVo;

import java.util.*;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        Solution solution = binaryTreeInorderTraversal.new Solution();
        TreeNode node3 = binaryTreeInorderTraversal.new TreeNode(3);
        TreeNode node2 = binaryTreeInorderTraversal.new TreeNode(2, node3, null);
        TreeNode node1 = binaryTreeInorderTraversal.new TreeNode(1, null, node2);
        List<Integer> list = solution.inorderTraversal(null);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null){
                return new ArrayList<>();
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            List<Integer> list = new ArrayList<>();
            Set<TreeNode> visited = new HashSet<>();
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (visited.contains(cur)) {
                    stack.pop();
                    continue;
                }
                if (cur.left != null && !visited.contains(cur.left)) {
                    stack.push(cur.left);
                    continue;
                }
                list.add(cur.val);
                visited.add(cur);
                if (cur.right != null && !visited.contains(cur.right)) {
                    stack.push(cur.right);
                    continue;
                }
                stack.pop();
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}