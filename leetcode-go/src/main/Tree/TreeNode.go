package Tree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func BuildTreeNode(array []int) *TreeNode {
	if nil == array || len(array) < 1 {
		return nil
	}

	return buildTreeNode(array, 0)
}

// 使用 -1 代表 nil
func buildTreeNode(array []int, index int) *TreeNode {
	var root *TreeNode
	if index < len(array) && -1 != array[index] {
		root := TreeNode{
			Val: array[index],
		}

		root.Left = buildTreeNode(array, index*2+1)
		root.Right = buildTreeNode(array, index*2+1)
	}

	return root
}
