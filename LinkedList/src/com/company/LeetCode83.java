package com.company;

public class LeetCode83 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode list = head;
        while(list != null && list.next != null) {
            if(list.val == list.next.val) list.next = list.next.next;
            else list = list.next;
        }
        return head;
    }
}
