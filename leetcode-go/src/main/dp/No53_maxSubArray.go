package dp

// MaxSubArray 最大子序列和
// 使用动态规划，把问题看作第 i 个数字结尾的最大连续子数组和
// 因此我们只需要求出每个位置的 f(i)f(i)，然后返回 f 数组中的最大值即可。
// 状态转移方程： f(i)=max{f(i−1)+nums[i],nums[i]}
func MaxSubArray(nums []int) int {
	n := len(nums)
	if n == 1 {
		return nums[0]
	}

	maxSum := nums[0]
	for i, n := 1, len(nums); i < n; i++ {
		if nums[i]+nums[i-1] > nums[i] {
			nums[i] += nums[i-1]
		}

		if nums[i] > maxSum {
		}
	}

	return maxSum
}
