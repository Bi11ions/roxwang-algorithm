package dp

// UniquePathsWithObstacles 不同路径
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 障碍物不可走
func UniquePathsWithObstacles(obstacleGrid [][]int) int {
	if obstacleGrid[0][0] == 1 {
		return 0
	}

	m := len(obstacleGrid)
	n := len(obstacleGrid[0])

	dp := make([][]int, m)
	for i := range dp {
		dp[i] = make([]int, n)
	}

	// 初始化
	dp[0][0] = 1
	for i := 1; i < m; i++ {
		if obstacleGrid[i][0] == 1 {
			dp[i][0] = 0
			continue
		}

		dp[i][0] = dp[i-1][0]
	}

	for j := 1; j < n; j++ {
		if obstacleGrid[0][j] == 1 {
			dp[0][j] = 0
			continue
		}

		dp[0][j] = dp[0][j-1]
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			if obstacleGrid[i][j] == 1 {
				dp[i][j] = 0
			} else {
				dp[i][j] = dp[i-1][j] + dp[i][j-1]
			}
		}
	}

	return dp[m-1][n-1]
}
