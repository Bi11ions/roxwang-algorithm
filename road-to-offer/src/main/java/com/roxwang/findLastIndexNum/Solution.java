package com.roxwang.findLastIndexNum;

import com.roxwang.Model.ListNode;

/**
 * 输入一个链表，输出该链表倒数第 k 个节点
 * 解析：
 * 链表倒数第 k 个节点，也就是正数第 Length - k + 1 个节点
 */
public class Solution {
    public static ListNode getLastIndexNode(ListNode head, int k) {
        // 非法数据直接返回
        if (null == head || k < 1) {
            return null;
        }

        ListNode node1 = head;
        ListNode node2 = head;
        int count = 0;
        int index = k;

        while (null != node1) {
            node1 = node1.next;
            count++;
            if (1 > k) {
                node2 = node2.next;
            }

            k--;
        }

        if (count < index) {
            return null;
        }

        return node2;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode node = getLastIndexNode(a, 2);
        System.out.println(node.val);
    }
}
