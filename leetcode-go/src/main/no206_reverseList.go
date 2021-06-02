package main

func ReverseList(head *ListNode) *ListNode {
	if nil == head || nil == head.Next {
		return head
	}

	tail := head.Next
	for nil != tail.Next {
		tail = tail.Next
	}

	// 新的末尾
	newTail := tail.Next
	for newTail != tail {
		nex := head.Next
		head.Next = newTail
		newTail = head
		head = nex
	}

	return tail
}
