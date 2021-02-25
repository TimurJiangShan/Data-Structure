package com.company;

public class LeetCode141_fast_slow_pointer {
      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    // 如果链表上有环，那么快指针和慢指针总会相遇
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode fast = head;
        ListNode slow = head;

        fast = fast.next.next;
        slow = slow.next;

        // 快慢指针的跳出条件是fast指针为空，或者它的下一个节点是空
        while(fast != null && fast.next != null) {
            if(fast == slow) {
                return true;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }

        return false;

    }
}
