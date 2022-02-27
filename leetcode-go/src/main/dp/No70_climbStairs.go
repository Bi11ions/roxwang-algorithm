package dp

// ClimbStairs 爬楼梯
// 状态转移函数 f(n) = f(n - 1) + f(n - 2)
func ClimbStairs(n int) int {
	dp := make([]int, n+1)
	dp[0], dp[1] = 1, 1
	for i := 2; i <= n; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}

	return dp[n-1]
}

// 使用滚动数组的方式，实现 O(1) 空间实现斐波那契数组
func climbStairs2(n int) int {
	dp := [2]int{1, 1}

	for i := 2; i <= n; i++ {
		dp[i%2] = dp[0] + dp[1]
	}

	return dp[n%2]
}
