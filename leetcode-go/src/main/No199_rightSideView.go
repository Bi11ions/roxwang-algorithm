package main

// RightSideView 二叉树的右视图
// 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
func RightSideView(root *TreeNode) []int {
	var result []int
	if root == nil {
		return result
	}

	dfsRightSideView(root, 0, &result)
	return result
}

func dfsRightSideView(root *TreeNode, depth int, result *[]int) {
	if nil == root {
		return
	}

	// 先访问 当前节点，再递归地访问 右子树 和 左子树。
	if depth == len(*result) {
		// 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
		*result = append(*result, root.Val)
	}

	depth++
	dfsRightSideView(root.Right, depth, result)
	dfsRightSideView(root.Left, depth, result)
}
