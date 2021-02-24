package com.company;

public class LeetCode160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        /**
         A 链表遍历到尾巴就转移到B链表
         B 链表遍历到尾巴就转移到A链表
         如果一轮后还不相等 就返回null
         这里A和B恰好都为null，A == B，就返回A

         A 走过的路程是A+B
         B 走过的路程是B+A
         当两个链表不相交的时候，A和B会同时为null，从而跳出循环。返回空节点
         */
        while(A != B) {
            if(A == null) A = headB;
            else A = A.next;

            if(B == null) B = headA;
            else B = B.next;
        }

        return A;
    }

}
