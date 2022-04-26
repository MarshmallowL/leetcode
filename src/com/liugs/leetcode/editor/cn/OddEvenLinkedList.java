  //给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。 
//
// 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。 
//
// 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。 
//
// 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,3,5,2,4] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [2,1,3,5,6,4,7]
//输出: [2,3,6,7,1,5,4] 
//
// 
//
// 提示: 
//
// 
// n == 链表中的节点数 
// 0 <= n <= 10⁴ 
// -10⁶ <= Node.val <= 10⁶ 
// 
// Related Topics 链表 👍 576 👎 0

  
  package com.liugs.leetcode.editor.cn;

  import com.liugs.leetcode.editor.cn.commonObj.ListNode;

  public class OddEvenLinkedList{
      public static void main(String[] args) {
           Solution solution = new OddEvenLinkedList().new Solution();
           ListNode node1 = new ListNode(1);
           ListNode node2 = new ListNode(2);
           ListNode node3 = new ListNode(3);
           ListNode node4 = new ListNode(4);
           ListNode node5 = new ListNode(5);
           node1.next = node2;
          node2.next = node3;
          node3.next = node4;
          node4.next = node5;
          System.out.println(solution.oddEvenList(node1));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode oddHead = head;
        ListNode oddNode = head;
        ListNode evenHead = head.next;
        ListNode evenNode = head.next;
        head = head.next;
        int i = 1;
        while (head.next != null){
            if (i == 1){
                oddNode.next = head.next;
                oddNode = oddNode.next;
                i = 0;
            }else {
                evenNode.next = head.next;
                evenNode = evenNode.next;
                i = 1;
            }
            head = head.next;
        }
        if (evenNode.next != null){
            evenNode.next = null;
        }
        oddNode.next = evenHead;
        return oddHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }