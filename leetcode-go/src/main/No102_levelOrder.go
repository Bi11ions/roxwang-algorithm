package main

// LevelOrder 二叉树的层序遍历
// 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
func LevelOrder(root *TreeNode) [][]int {
	if nil == root {
		return [][]int{}
	}

	var resultList [][]int
	queue := []*TreeNode{root}
	for level := 0; len(queue) > 0; level++ {
		var values []int
		q := queue
		queue = nil
		for _, node := range q {
			values = append(values, node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}

			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}

		resultList = append(resultList, values)
	}

	return resultList
}
