package dp

// UniquePaths 不同路径
func UniquePaths(m int, n int) int {
	if m == 1 || n == 1 {
		return 1
	}

	dp := make([][]int, m)
	for i := range dp {
		dp[i] = make([]int, n)
	}

	// 初始化边界值
	dp[0][0] = 1
	for i := 1; i < m; i++ {
		dp[i][0] = 1
	}

	for i := 1; i < n; i++ {
		dp[0][i] = 1
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[i][j] = dp[i-1][j] + dp[i][j-1]
		}
	}

	return dp[m-1][n-1]
}
