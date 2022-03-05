package dp

// MinDistance2 编辑距离
// 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
// 你可以对一个单词进行如下三种操作：
//   插入一个字符 	相当于 ==> dp[i][j-1] + 1
//   删除一个字符 	相当于 ==> dp[i-1][j] + 1
//   替换一个字符 	相当于 ==> dp[i-1][j-1] + 1
// 状态转移方程： dp[i][j] = dp[i-1][j-1],  	 word1[i] == word2[j]时
// 						= min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1, word1[i] != word2[j]时
func MinDistance2(word1, word2 string) int {
	m := len(word1)
	n := len(word2)
	// 空串
	if m*n == 0 {
		return n + m
	}

	dp := make([][]int, m+1)
	for i := range dp {
		dp[i] = make([]int, n+1)
	}

	for i := 1; i < m+1; i++ {
		dp[i][0] = dp[i-1][0] + 1
	}

	for j := 1; j < n+1; j++ {
		dp[0][j] = dp[0][j-1] + 1
	}

	for i := 1; i < m+1; i++ {
		for j := 1; j < n+1; j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
				continue
			}

			dp[i][j] = 1 + minInThree(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])
		}
	}

	return dp[m][n]
}

func minInThree(m, n, x int) int {
	return min(min(m, n), x)
}
