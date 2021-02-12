package com.company;

public class ReverseBetween {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode successor = null;

    // Reverse list from head, n times and return new head;
    ListNode reverseN(ListNode head, int n){
        if(n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        // If m equals 1; the problem can be converted into reverseN;
        if(m == 1) {
            return reverseN(head, n);
        }

        // head => m; head.next => m - 1
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
