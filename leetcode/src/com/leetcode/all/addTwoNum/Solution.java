package com.leetcode.all.addTwoNum;


/**
 * @author wangsen@qgutech.com
 * @since 2019/7/16 8:45
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode current = head;
        int carry = 0;
        while (null != p1 || null != p2) {
            int x = p1 != null ? p1.val : 0;
            int y = p2 != null ? p2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (null != p1) {
                p1 = p1.next;
            }

            if (null != p2) {
                p2 = p2.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l3.next = new ListNode(3);
        l1.next = l3;
        ListNode l2 = new ListNode(5);
        ListNode l4 = new ListNode(6);
        l4.next = new ListNode(4);
        l2.next = l4;
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        if (null == listNode) {
            return;
        }

        StringBuilder sb = new StringBuilder(listNode.val);
        for (; ; ) {
            sb.append(listNode.val);
            if (null == listNode.next) {
                break;
            }

            listNode = listNode.next;
        }

        System.out.println(sb.reverse().toString());
    }
}

class ListNode {
    Integer val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}