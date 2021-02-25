package com.company;

public class LeetCode876_fast_slow_pointer {
    public ReverseBetween.ListNode middleNode(ReverseBetween.ListNode head) {
        // 快慢指针
        ReverseBetween.ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
