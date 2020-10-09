package com.company;

public class LeetCode203 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;

        ListNode restList = removeElements(head.next, val);
        if (head.val == val) {
            return restList;
        } else {
            head.next = restList;
            return head;
        }
    }

}

/**
 * head 9-> null; restList = removeElement(null, val);
 * head null
 * head 9-> null; restList = null;
 * head 8-> 9 -> null; restList = null; head 是 8-> null;
 * head 7->8->9->null; restList = 8->null; head 是 7->8->null;
 * head 6->7->8->9->null; restList = 7->8->null; head是 6->7->8->null;
 * ......
 * head 1->2->3->4->5->6->7->8->9->null, restList = 2->3->4->5->6->7->8->null; head是1->2->3->4->5->6->7->8->9->null
 * **/
