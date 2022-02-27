package lists

import (
	"fmt"
	"math/rand"
)

const (
	// 最大层数
	maxLevel = 32
	// 随机层数概率，也就是随机出的层数，在 第1层以上(不包括第一层)的概率，层数不超过maxLevel，层数的起始号为1
	probability = 0.25
)

type skipNode struct {
	value int
	right *skipNode
	down  *skipNode
}

type Skiplist struct {
	head *skipNode
}

func Constructor() Skiplist {
	left := make([]*skipNode, maxLevel)
	right := make([]*skipNode, maxLevel)
	for i := 0; i < maxLevel; i++ {
		left[i] = &skipNode{-1, nil, nil}
		right[i] = &skipNode{20001, nil, nil}
	}
	for i := maxLevel - 2; i >= 0; i-- {
		left[i].right = right[i]
		left[i].down = left[i+1]
		right[i].down = right[i+1]
	}
	left[maxLevel-1].right = right[maxLevel-1]
	return Skiplist{left[0]}
}

func (this *Skiplist) Search(target int) bool {
	node := this.head
	for node != nil {
		if node.right.value > target {
			node = node.down
		} else if node.right.value < target {
			node = node.right
		} else {
			return true
		}
	}
	return false
}

func (this *Skiplist) Add(num int) {
	prev := make([]*skipNode, maxLevel)
	i := 0
	node := this.head
	for node != nil {
		if node.right.value >= num {
			prev[i] = node
			i++
			node = node.down
		} else {
			node = node.right
		}
	}
	n := randLevel()
	arr := make([]*skipNode, n)
	t := &skipNode{-1, nil, nil}
	for i, a := range arr {
		p := prev[maxLevel-n+i]
		a = &skipNode{num, p.right, nil}
		p.right = a
		t.down = a
		t = a
	}
}

// Erase 删除
func (this *Skiplist) Erase(num int) bool {
	ans := false
	node := this.head
	for node != nil {
		if node.right.value > num {
			node = node.down
		} else if node.right.value < num {
			node = node.right
		} else {
			ans = true
			node.right = node.right.right
			node = node.down
		}
	}
	return ans
}

func randLevel() int {
	level := 1
	// 两层概率0.25，每加一层*0.25
	for rand.Float64() < probability && level < maxLevel {
		level++
	}

	return level
}

func (this *Skiplist) Test() {
	//测试用例
	test := Constructor()
	test.Add(1)
	test.Add(4)
	test.Add(7)
	test.Add(9)
	test.Add(13)
	test.Add(16)
	test.Add(12)
	test.Add(11)
	test.Add(100)
	suc := test.Erase(8)
	fmt.Println("是否删除成功", suc)
	fmt.Println("一共", test, "层")
}
