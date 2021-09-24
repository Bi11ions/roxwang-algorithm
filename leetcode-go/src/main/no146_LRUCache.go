package main

type LRUCache struct {
	head, tail *Node
	Keys       map[int]*Node
	Cap        int
}

type Node struct {
	Key, Val   int
	Prev, Next *Node
}

func Constructor(capacity int) LRUCache {
	return LRUCache{Keys: make(map[int]*Node), Cap: capacity}
}

// Get 查询key对应的节点，并将该节点移动到链表头部
func (invoker *LRUCache) Get(key int) int {
	if node, ok := invoker.Keys[key]; ok {
		invoker.Remove(node)
		invoker.Add(node)
		return node.Val
	}

	return -1
}

// Put 新增元素，并将该元素放在头节点。 若新增后超出长度，则删除尾节点
func (invoker *LRUCache) Put(key, value int) {
	if node, ok := invoker.Keys[key]; ok {
		node.Val = value
		invoker.Remove(node)
		invoker.Add(node)
		return
	} else {
		node = &Node{Key: key, Val: value}
		invoker.Keys[key] = node
		invoker.Add(node)
	}

	if len(invoker.Keys) > invoker.Cap {
		delete(invoker.Keys, invoker.tail.Key)
		invoker.Remove(invoker.tail)
	}
}

// Add 新增节点, 头插法
func (invoker *LRUCache) Add(node *Node) {
	node.Prev = nil
	node.Next = invoker.head
	if invoker.head != nil {
		invoker.head.Prev = node
	}

	invoker.head = node
	if invoker.tail == nil {
		invoker.tail = node
		invoker.tail.Next = nil
	}
}

// Remove 删除结点
func (invoker *LRUCache) Remove(node *Node) {
	// 头节点
	if node == invoker.head {
		invoker.head = node.Next
		node.Next = nil
		return
	}

	// 尾节点
	if node == invoker.tail {
		invoker.tail = node.Prev
		node.Prev.Next = nil
		node.Prev = nil
		return
	}

	// 中间节点
	node.Prev.Next = node.Next
	node.Next.Prev = node.Prev
}
