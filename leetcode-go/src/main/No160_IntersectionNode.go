package main

// pA走过的路径为A链+B链
// pB走过的路径为B链+A链
// pA和pB走过的长度都相同，都是A链和B链的长度之和，相当于将两条链从尾端对齐，如果相交，则会提前在相交点相遇，如果没有相交点，则会在最后相遇。
// pA:1->2->3->4->5->6->null->9->5->6->null
// pB:9->5->6->null->1->2->3->4->5->6->null
func GetIntersectionNode(headA, headB *ListNode) *ListNode {
	if nil == headA || nil == headB {
		return nil
	}

	pA, pB := headA, headB
	for pA != pB {
		if nil == pA {
			pA = headB
		} else {
			pA = pA.Next
		}

		if nil == pB {
			pB = headA
		} else {
			pB = pB.Next
		}
	}

	return pA
}
