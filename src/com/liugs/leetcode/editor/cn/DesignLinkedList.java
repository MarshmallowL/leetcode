//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 👍 414 👎 0


package com.liugs.leetcode.editor.cn;

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new DesignLinkedList().new MyLinkedList();
        list.addAtHead(2);
        list.deleteAtIndex(1);
        list.addAtHead(2);
        list.addAtHead(7);
        list.addAtHead(3);
        list.addAtHead(2);
        list.addAtHead(2);
        list.addAtHead(5);
        list.addAtTail(5);
        System.out.println(list.get(5));
        list.deleteAtIndex(6);
        list.deleteAtIndex(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {
        private class Node {
            private int val;
            private Node next;

            public Node(int val) {
                this.val = val;
            }

            public int getVal() {
                return val;
            }

            public void setVal(int val) {
                this.val = val;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }

        private final Node head;
        private int len;

        public MyLinkedList() {
            head = new Node(-1);
            len = 0;
        }

        private boolean isEmpty() {
            return len == 0;
        }

        public int get(int index) {
            if (index < 0) {
                return -1;
            }
            int i = 0;
            Node cur = head.next;
            while (i < len) {
                if (i == index) {
                    return cur.val;
                }
                cur = cur.next;
                i++;
            }
            return -1;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            if (!isEmpty()) {
                node.next = head.next;
            }
            head.next = node;
            len++;
        }

        public void addAtTail(int val) {
            if (isEmpty()) {
                head.next = new Node(val);
            } else {
                Node cur = head;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = new Node(val);
            }
            len++;
        }

        public void addAtIndex(int index, int val) {
            if (index > len || index < 0) {
                return;
            }
            int i = 0;
            Node cur = head;
            while (i < index) {
                cur = cur.next;
                i++;
            }
            Node node = new Node(val);
            node.next = cur.next;
            cur.next = node;
            len++;
        }

        public void deleteAtIndex(int index) {            if (index < 0|| index >= len) {
                return;
            }
            int i = 0;
            Node cur = head;
            while (i < index && cur.next != null) {
                cur = cur.next;
                i++;
            }
            if (cur.next != null) {
                cur.next = cur.next.next;
            }
            len--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}