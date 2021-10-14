package lists

// mergeTwoLists 合并两个有序链表. 迭代法
func mergeTwoLists(l1, l2 *ListNode) *ListNode {
	preHead := &ListNode{Val: -1}
	prev := preHead
	for nil != l1 && nil != l2 {
		if l1.Val <= l2.Val {
			prev.Next = l1
			l1 = l1.Next
		} else {
			prev.Next = l2
			l2 = l2.Next
		}

		prev = prev.Next
	}

	if nil == l1 {
		prev.Next = l2
	}

	if nil == l2 {
		prev.Next = l1
	}

	return preHead.Next
}

// 递归
func mergeTwoLists1(l1, l2 *ListNode) *ListNode {
	if nil == l1 {
		return l2
	}

	if nil == l2 {
		return l1
	}

	if l1.Val <= l2.Val {
		l1.Next = mergeTwoLists(l1.Next, l2)
		return l1
	}

	l2.Next = mergeTwoLists(l1, l2.Next)
	return l2
}
