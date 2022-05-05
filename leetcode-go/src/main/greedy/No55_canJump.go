package greedy

// CanJump 跳跃游戏
// 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 数组中的每个元素代表你在该位置可以跳跃的最大长度。
// 判断你是否能够到达最后一个下标。
// 1 <= nums.length <= 3 * 10^4
// 0 <= nums[i] <= 10^5
func CanJump(nums []int) bool {
	n := len(nums)
	// 维护每个位置可以到达得最大位置
	rightMost := 0
	for i, num := range nums {
		if i <= rightMost {
			rightMost = max(i+num, rightMost)
			if rightMost >= n-1 {
				return true
			}
		}

	}

	return false
}

func max(m, n int) int {
	if m > n {
		return m
	}

	return n
}
