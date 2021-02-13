package com.company;

public class ReverseBetween {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode successor = null; // 后驱节点

    // 反转以 head为起点的n个节点，返回新的头节点
    ListNode reverseN(ListNode head, int n){
        if(n == 1) {
            // 记录第n+1个节点
            successor = head.next;
            return head;
        }

        // 以 head.next 为起点，需要反转前 n-1 个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的head节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        // If m equals 1; the problem can be converted into reverseN;
        if(m == 1) {
            // 相当于反转前 n 个元素
            return reverseN(head, n);
        }

        // head => m; head.next => m - 1
        // 前进到反转的起点触发base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
