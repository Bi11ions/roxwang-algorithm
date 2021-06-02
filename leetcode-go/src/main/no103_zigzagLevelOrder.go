package main

// 二叉树的锯齿形层次遍历
func zigzagLevelOrder(root *TreeNode) [][]int {
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

		if level%2 == 1 {
			for i, n := 0, len(values); i < n/2; i++ {
				values[i], values[n-1-i] = values[n-1-i], values[i]
			}
		}

		resultList = append(resultList, values)
	}

	return resultList
}
