package greedy

// Jump 跳跃游戏2
// 给你一个非负整数数组 nums，你最初位于数组的第一个位置。
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
// 假设你总是可以到达数组的最后一个位置。
// 1 <= nums.length <= 10^4
// 0 <= nums[i] <= 1000
func Jump(nums []int) int {
	n := len(nums)
	// 记录需要条约访问得下标，根据 maxRight
	end := 0
	// 维护到当前节点累计能够到达的最大下标位置，记为边界，在当前位置到边界
	maxRight := 0
	steps := 0
	for i := 0; i < n-1; i++ {
		maxRight = max(i+nums[i], maxRight)
		// 当位置为上个节点能够访问得最大节点时，步骤+1
		if i == end {
			end = maxRight
			steps++
		}
	}

	return steps
}
