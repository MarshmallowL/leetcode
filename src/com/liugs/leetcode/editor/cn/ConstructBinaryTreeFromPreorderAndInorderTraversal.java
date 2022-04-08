  //给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1525 👎 0

  
  package com.liugs.leetcode.editor.cn;

  import com.liugs.leetcode.editor.cn.commonObj.TreeNode;

  import java.util.HashMap;
  import java.util.Map;

  public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
          int[] preorder = new int[]{3,9,20,15,7};
          int[] inorder =new int[]{9,3,15,20,7};
          TreeNode node = solution.buildTree(preorder,inorder);
          System.out.println(node.val);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer,Integer> idxMap = new HashMap<>();
    private int preIdx = 0;
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i],i);
        }
        return build(0,inorder.length);

    }

    private TreeNode build(int left,int right){
        if (left > right || preIdx > preorder.length - 1){
            return null;
        }
        int rootVal = preorder[preIdx];
        preIdx++;
        int idx = idxMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = build(left,idx-1);
        root.right = build(idx+1,right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }