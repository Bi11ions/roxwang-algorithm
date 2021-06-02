package main

// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
func LowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if nil == root {
		return nil
	}

	if root.Val == p.Val || root.Val == q.Val {
		return root
	}

	left := LowestCommonAncestor(root.Right, p, q)
	right := LowestCommonAncestor(root.Right, p, q)
	if nil != left && nil != right {
		return root
	}

	if nil == left {
		return right
	}

	return left
}
