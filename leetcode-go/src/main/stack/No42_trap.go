package stack

import math "math"

// Trap 接雨水
func Trap(height []int) int {
	return trapDoublePointer(height)
}

// trapInStack 使用栈的方式
// 使用栈来存储条形块的索引下标。
// 遍历数组：
// 当栈非空且 height[current] > height[st.top()]
// 意味着栈中元素可以被弹出。弹出栈顶元素 top。
// 计算当前元素和栈顶元素的距离，准备进行填充操作
//     distance = current−st.top()−1
// 找出界定高度
//     bounded_height = min(height[current],height[st.top()]) − height[top]
// 往答案中累加积水量 ans += distance × bounded_height
// 将当前索引下标入栈
// 将 current 移动到下个位置
func trapInStack(height []int) int {
	stack := make([]int, 0)
	ans, cur, size := 0, 0, len(height)
	for cur < size {
		for len(stack) != 0 && height[cur] > height[stack[len(stack)-1]] {
			// 弹出栈顶
			top := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			if len(stack) == 0 {
				break
			}

			// 计算距离
			distance := cur - stack[len(stack)-1] - 1
			// 计算高度
			h := min(height[cur], height[stack[len(stack)-1]]) - height[top]
			// 计算容积
			ans += h * distance
		}

		// 压入栈
		stack = append(stack, cur)
		cur++
	}

	return ans
}

func min(a, b int) int {
	if a < b {
		return a
	}

	return b
}

// trapInDP 使用 DP 的方法解
// 找到数组中从下标 i 到最左端最高的条形块高度 left_max。
// 找到数组中从下标 i 到最右端最高的条形块高度 right_max。
// 扫描数组 height 并更新答案：
// 累加 min(max_left[i],max_right[i]) - height[i] 到 ans 上
func trapInDP(height []int) int {
	if nil == height || len(height) < 1 {
		return 0
	}

	ans, size := 0, len(height)
	left_max, right_max := make([]int, size), make([]int, size)
	// 从左往右，找到左边最大的一个
	left_max[0] = height[0]
	for i := 1; i < size; i++ {
		left_max[i] = int(math.Max(float64(height[i]), float64(left_max[i-1])))
	}
	// 从右往左，找到右边最大的一个
	right_max[size-1] = height[size-1]
	for i := size - 2; i >= 0; i-- {
		right_max[i] = int(math.Max(float64(height[i]), float64(right_max[i+1])))
	}

	// 找出当前为位置，左右两个方向最大值的中的一个最小值，再减去当前位置的值，表示在当前位置可以接到的余量
	for i := 1; i < size-1; i++ {
		ans += int(math.Min(float64(left_max[i]), float64(right_max[i]))) - height[i]
	}

	return ans
}

// 双指针用法
// 从动态编程方法的示意图中我们注意到，只要 right_max[i]>left_max[i] （元素 0 到元素 6），
// 积水高度将由 left_max 决定，类似地 left_max[i]>right_max[i]（元素 8 到元素 11）。
// 所以我们可以认为如果一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。
// 当我们发现另一侧（右侧）的条形块高度不是最高的，我们则开始从相反的方向遍历（从右到左）。
// 我们必须在遍历时维护 left_max 和 right_max ，但是我们现在可以使用两个指针交替进行，实现 1 次遍历即可完成。
func trapDoublePointer(height []int) int {
	left, right := 0, len(height)-1
	ans := 0
	left_max, right_max := 0, 0
	for left < right {
		if height[left] < height[right] {
			if height[left] >= left_max {
				left_max = height[left]
			} else {
				ans += left_max - height[left]
			}

			left += 1
		} else {
			if height[right] > right_max {
				right_max = height[right]
			} else {
				ans += right_max - height[right]
			}
			right -= 1
		}
	}

	return ans
}
