package lists

// 寻找链表倒数第K个元素
func FindKthInList(head *ListNode, k int) *ListNode {
	if nil == head || k < 1 {
		return nil
	}

	first, second := head, head
	h := k
	count := 0

	for nil != first {
		first = first.Next
		count++
		if h < 1 {
			second = second.Next
		}

		h--
	}

	if count < k {
		return nil
	}

	return second
}
