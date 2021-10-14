package Tree

// 根据前序遍历与中序遍历数组构建树
// 思路
// 	对于任意一颗树而言，前序遍历的形式总是
// 		[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
// 		即根节点总是前序遍历中的第一个节点。
// 	而中序遍历的形式总是
// 		[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
// 		只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。
// 由于同一颗子树的前序遍历和中序遍历的长度显然是相同的， 因此我们就可以对应到前序遍历的结果中，对上述形式中的所有左右括号进行定位。
// 这样以来，我们就知道了左子树的前序遍历和中序遍历结果，以及右子树的前序遍历和中序遍历结果，我们就可以递归地对构造出左子树和右子树，再将这两颗子树接到根节点的左右位置。
//
// 细节
// 	在中序遍历中对根节点进行定位时，一种简单的方法是直接扫描整个中序遍历的结果并找出根节点，但这样做的时间复杂度较高。
// 	我们可以考虑使用哈希表来帮助我们快速地定位根节点。对于哈希映射中的每个键值对，键表示一个元素（节点的值），值表示其在中序遍历中的出现位置。
// 	在构造二叉树的过程之前，我们可以对中序遍历的列表进行一遍扫描，就可以构造出这个哈希映射。在此后构造二叉树的过程中，我们就只需要 O(1)O(1) 的时间对根节点进行定位了。
func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}

	root := &TreeNode{preorder[0], nil, nil}
	i := 0
	for ; i < len(inorder); i++ {
		if inorder[i] == preorder[0] {
			break
		}
	}

	// 初始化切片 s，是数组 arr 的引用。
	// 		s := arr[startIndex:endIndex]
	// 将 arr 中从下标 startIndex 到 endIndex-1 下的元素创建为一个新的切片。
	// 		s := arr[startIndex:]
	// 默认 endIndex 时将表示一直到arr的最后一个元素。
	// 		s := arr[:endIndex]
	root.Left = buildTree(preorder[1:len(inorder[:i])+1], inorder[:i])
	root.Right = buildTree(preorder[len(inorder[:i])+1:], inorder[i+1:])
	return root
}

// 根据中序遍历和后序遍历构造树
// 思路
// 迭代法是一种非常巧妙的实现方法。
// 对于前序遍历中的任意两个连续节点 u 和 v，根据前序遍历的流程，我们可以知道 u 和 v 只有两种可能的关系：
// 		v 是 u 的左儿子。这是因为在遍历到 u 之后，下一个遍历的节点就是 u 的左儿子，即 v；
// 		u 没有左儿子，并且 v 是 u 的某个祖先节点（或者 u 本身）的右儿子。如果 u 没有左儿子，那么下一个遍历的节点就是 u 的右儿子。如果 u 没有右儿子，
// 			我们就会向上回溯，直到遇到第一个有右儿子（且 u 不在它的右儿子的子树中）的节点 u_a，那么 v 就是 u_a  的右儿子。
func buildTreeInIteration(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}

	root := &TreeNode{preorder[0], nil, nil}
	var stack []*TreeNode
	stack = append(stack, root)
	var inorderIndex int
	for i := 1; i < len(preorder); i++ {
		preorderVal := preorder[i]
		node := stack[len(stack)-1]
		if node.Val != inorder[inorderIndex] {
			node.Left = &TreeNode{preorderVal, nil, nil}
			stack = append(stack, node.Left)
		} else {
			for len(stack) != 0 && stack[len(stack)-1].Val == inorder[inorderIndex] {
				node = stack[len(stack)-1]
				stack = stack[:len(stack)-1]
				inorderIndex++
			}

			node.Right = &TreeNode{preorderVal, nil, nil}
			stack = append(stack, node.Right)
		}
	}

	return root
}

// 中序遍历和后序遍历构造二叉树
// 思路
// 	对于任意一颗树而言，后续遍历的形式总是
// 		[ [左子树的前序遍历结果], [右子树的前序遍历结果], 根节点]
// 		即根节点总是后续遍历中的最后一个节点。
// 	而中序遍历的形式总是
// 		[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
func buildTreePostorder(inorder []int, postorder []int) *TreeNode {
	if len(postorder) == 0 {
		return nil
	}

	root := &TreeNode{postorder[len(postorder)-1], nil, nil}
	i := 0
	for ; i < len(inorder); i++ {
		if inorder[i] == postorder[len(postorder)-1] {
			break
		}
	}

	root.Left = buildTreePostorder(inorder[:i], postorder[:i])
	root.Right = buildTreePostorder(inorder[i+1:], postorder[i:len(postorder)-1])
	return root
}
