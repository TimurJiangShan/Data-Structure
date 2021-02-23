package com.company;

public class LeetCode237 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public void deleteNode(ListNode node) {
        ListNode prev = new ListNode(0);
        // 记得删除多余的节点。用后面的值覆盖前面值的方法
        while(node.next != null){
            prev = node;
            node.val = node.next.val;
            node = node.next;
        }
        prev.next = null;
    }
}
