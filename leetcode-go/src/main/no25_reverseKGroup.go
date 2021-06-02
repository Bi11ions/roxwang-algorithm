package main

/**
给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
k是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
*/
func ReverseKGroup(head *ListNode, k int) *ListNode {
	hair := &ListNode{Next: head}
	pre := hair
	for nil != head {
		tail := pre
		// 若剩余长度不大于 k， 那么直接返回
		for i := 0; i < k; i++ {
			tail = tail.Next
			if nil == tail {
				return hair.Next
			}
		}

		nex := tail.Next
		head, tail = MyReverse(head, tail)
		// 把子链接回原链表
		pre.Next = head
		tail.Next = nex
		pre = tail
		head = tail.Next
	}

	return hair.Next
}

func MyReverse(head, tail *ListNode) (*ListNode, *ListNode) {
	prev := tail.Next
	p := head
	for prev != tail {
		nex := p.Next
		p.Next = prev
		prev = p
		p = nex
	}

	return tail, head
}
