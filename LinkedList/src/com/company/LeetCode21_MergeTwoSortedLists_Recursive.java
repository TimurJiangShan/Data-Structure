package com.company;

public class LeetCode21_MergeTwoSortedLists_Recursive {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeHelper(l1,l2);

    }

    private ListNode mergeHelper(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeHelper(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeHelper(l1, l2.next);
            return l2;
        }

    }
}
