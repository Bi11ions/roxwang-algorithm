package dp

// LongestCommonSubsequence 最长公共子序列
// text1 = "abcde", text2 = "ace" -> result = 3(ace)
// 状态转移方程 text1[i-1] == text2[j-1] 时 dp[i][j] = dp[i-1][j-1] + 1
//           text1[i-1] != text2[j-1] 时          = max(dp[i-1][j], dp[i][j-1])
func LongestCommonSubsequence(text1 string, text2 string) int {
	n := len(text1)
	m := len(text2)

	// 默认扩大1个单位，从 1 开始，默认 d[m][0] 与 d[0][n] 都为0，这样省去初始化步骤
	dp := make([][]int, m+1)
	for i := range dp {
		dp[i] = make([]int, n+1)
	}

	// 初始化步骤
	//if text1[0] == text2[0] {
	//	dp[0][0] = 1
	//} else {
	//	dp[0][0] = 0
	//}
	//
	//for i := 1; i < m; i++ {
	//	if text2[i] == text1[0] {
	//		dp[i][0] = 1
	//	} else {
	//		dp[i][0] = dp[i-1][0]
	//	}
	//}

	//for j := 1; j < n; j++ {
	//	if text2[0] == text1[j] {
	//		dp[0][j] = 1
	//	} else {
	//		dp[0][j] = dp[0][j-1]
	//	}
	//}

	for i := 1; i < m+1; i++ {
		for j := 1; j < n+1; j++ {
			if text1[j-1] == text2[i-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = max(dp[i][j-1], dp[i-1][j])
			}
		}
	}

	return dp[m][n]
}

func max(m int, n int) int {
	if m >= n {
		return m
	}

	return n
}
