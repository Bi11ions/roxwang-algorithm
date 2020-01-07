package com.roxwang.reversePrintList;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表的头结点，按照 从尾到头 的顺序返回节点的值。
 * 返回的结果用数组存储。
 * 样例:
 * 输入：[2, 3, 5]
 * 返回：[5, 3, 2]
 */
public class PrintListReverse {
    @Test
    public void testReversed() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 5, 6);
        List<Integer> reversedList = reverseList(list);
        for (Integer integer : reversedList) {
            System.out.print(integer + ",");
        }
    }

    // 遍历链表，每个链表结点值 push 进栈，最后将栈中元素依次 pop 到数组中。
    public List<Integer> reverseList(List<Integer> list) {
        if (null == list || list.size() < 1) {
            return new ArrayList<Integer>(0);
        }

        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> reversedList = new ArrayList<Integer>(list.size());
        for (Integer item : list) {
            stack.push(item);
        }

        while (!stack.isEmpty()) {
            reversedList.add(stack.pop());
        }

        return reversedList;
    }
}
