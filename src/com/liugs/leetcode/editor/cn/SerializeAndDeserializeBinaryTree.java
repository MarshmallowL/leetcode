//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
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
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 822 👎 0


package com.liugs.leetcode.editor.cn;

import com.liugs.leetcode.editor.cn.commonObj.TreeNode;

import java.time.Period;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec solution = new SerializeAndDeserializeBinaryTree().new Codec();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node3.left = node4;
        node3.right = node5;
        node1.left = node2;
        node1.right = node3;
        System.out.println(solution.serialize(node1));
        TreeNode root = solution.deserialize("1,2,3,null,null,4,5,null,null,null,null");
        System.out.println(root.val);

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curNode = queue.poll();
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    if (curNode == null){
                        sb.append("null");
                    }else {
                        sb.append(curNode.val);
                        queue.add(curNode.left != null ? curNode.left : null);
                        queue.add(curNode.right != null ? curNode.right : null);
                    }
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || "".equals(data) || "null".equals(data)) {
                return null;
            }
            String[] array = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(array[0]));
            queue.add(root);
            int i = 1, len = array.length;
            while (i < len && !queue.isEmpty()) {
                TreeNode node = queue.poll();
                for (int j = 0; j < 2; j++) {
                    if (i < len && !"null".equals(array[i])) {
                        TreeNode subNode = new TreeNode(Integer.parseInt(array[i]));
                        queue.add(subNode);
                        if (j == 0) {
                            node.left = subNode;
                        } else {
                            node.right = subNode;
                        }
                    }
                    i++;
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}