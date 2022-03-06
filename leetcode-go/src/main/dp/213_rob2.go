package dp

// Rob2 打家劫舍2
// 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
// 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
// 状态转移方程 dp(i) = max(dp[i-1], dp[i-2]+nums[i]) i != n-1时
// 					 边界 dp[0] = nums[0]
// 						 dp[1] = max(nums[1], nums[0])
// 区别是  i = n-1 时，dp[n-1] = max(dp[0:n-2], dp[1:n-1])
func Rob2(nums []int) int {
	n := len(nums)
	if n == 1 {
		return nums[0]
	} else if n == 2 {
		return max(nums[0], nums[1])
	}

	return max(rangRob(nums[:n-1]), rangRob(nums[1:]))
}

func rangRob(nums []int) int {
	first, second := nums[0], max(nums[0], nums[1])
	for _, v := range nums {
		first, second = second, max(first+v, second)
	}

	return second
}

func rangeRob2() {

}
