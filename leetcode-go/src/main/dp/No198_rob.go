package dp

// Rob 打家劫舍
// 你是一个专业的小偷，计划偷窃沿街的房屋。
// 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
// 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
// 状态转移方程 dp(i) = max(dp[i-1], dp[i-2]+nums[i])
// 					 边界 dp[0] = nums[0]
// 						 dp[1] = max(nums[1], nums[0])
func Rob(nums []int) int {
	n := len(nums)
	if 2 > n {
		return nums[0]
	}

	dp := make([]int, n)
	dp[0] = nums[0]
	dp[1] = max(nums[0], nums[1])
	for i := 2; i < n; i++ {
		dp[i] = max(dp[i-1], dp[i-2]+nums[i])
	}

	return dp[n-1]
}
