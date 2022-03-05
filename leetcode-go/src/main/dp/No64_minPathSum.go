package dp

// MinPathSum 最小路径和
// 状态转移方程 f(i, j) = f(i, j) + min(f(i-1, j), f(i, j-1))
func MinPathSum(grid [][]int) int {
	n := len(grid)
	m := len(grid[0])
	if n == 1 && m == 1 {
		return grid[0][0]
	}

	dp := make([][]int, n)
	for i := range dp {
		dp[i] = make([]int, m)
	}

	// 初始化
	dp[0][0] = grid[0][0]
	for i := 1; i < m; i++ {
		dp[0][i] += dp[0][i-1]
	}

	for i := 1; i < n; i++ {
		dp[i][0] += dp[i-1][0]
	}

	// 生成
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
		}
	}

	return dp[n-1][m-1]
}
