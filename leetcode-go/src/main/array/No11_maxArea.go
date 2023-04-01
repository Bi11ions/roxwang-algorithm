package array

// 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
//找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
//返回容器可以储存的最大水量。
//说明：你不能倾斜容器。 n == height.length

// MaxArea 最大容量
func MaxArea(height []int) int {
	// 当前面积 >= 下个距离得面积最大值
	length := len(height)
	left := 0
	right := length - 1
	maxArea := 0
	for left < right {
		// 若向内 移动短板 ，水槽的短板 min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
		// 若向内 移动长板 ，水槽的短板 min(h[i],h[j]) 不变或变小，因此下个水槽的面积 一定变小 。
		if height[left] > height[right] {
			maxArea = max(maxArea, height[right]*(right-left))
			right--
		} else {
			maxArea = max(maxArea, height[left]*(right-left))
			left++
		}
	}

	return maxArea
}
