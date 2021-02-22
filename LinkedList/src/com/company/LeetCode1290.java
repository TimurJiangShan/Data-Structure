package com.company;

public class LeetCode1290 {
    public int getDecimalValue(ReverseBetween.ListNode head) {

        int result = 0;
        while(head != null) {
            // 左移一位就是乘2，后移一位就是除2。 最后别忘了 result += result * 2;
            result <<= 1;

            result += result *2;
            head = head.next;
        }
        return result;
    }
}
