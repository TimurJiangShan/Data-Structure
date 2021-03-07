import java.util.List;

public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists){
        if(lists.size() == 0) {
            return null;
        }

        return mergeHelper(lists, 0, lists.size()-1);
    }

    private ListNode mergeHelper(List<ListNode> lists, int start, int end){
        if(start == end) {
            return lists.get(start);  
        }

        int mid = start + (end - start)/2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid+1, end);

        return mergeTwoLists(left, right);
    }

    // 迭代法比递归法要快
    private ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }

        if(list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // 这里的dummy 怎么就指向merge好的链表了？
        return dummy.next;

        // resursive
//         if(list1 == null || list2 == null) {
//             return list1 == null ? list2 : list1;
//         }

//         if(list1.val < list2.val) {
//             list1.next = mergeTwoSortLists(list1.next, list2);
//             return list1;
//         } else {
//             list2.next = mergeTwoSortLists(list1, list2.next);
//             return list2;
//         }
    }


}
