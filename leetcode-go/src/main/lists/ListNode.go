package lists

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func (node *ListNode) String() string {
	if nil == node.Next {
		return fmt.Sprintf("[Val:%d, Next:%s]", node.Val, "nil")
	}

	return fmt.Sprintf("[Val:%d, Next:%s]", node.Val, node.Next.String())
}

func BuildListNode(array []int) *ListNode {
	if len(array) < 1 {
		return nil
	}

	head := &ListNode{Val: array[0]}
	tail := &ListNode{Next: head}
	for i := 1; i < len(array); i++ {
		newNode := &ListNode{Val: array[i]}
		head.Next = newNode
		head = newNode
	}

	return tail.Next
}
