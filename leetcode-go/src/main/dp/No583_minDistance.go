package dp

// MinDistance 两个字符串的删除操作
// 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
// 思路1：
// 状态转移方程 word1[i] == word2[j]时，dp[i][j] == dp[i-1][j-1]
// 			  word1[i] != word2[j]时，dp[i][j] == 1 + min(dp[i][j-1], dp[i-1][j])
// 思路2：
// 可以找出最长公共字串lcs，则最少的删除步骤即为：m - lcs + n - lcs
func MinDistance(word1, word2 string) int {
	m := len(word1)
	n := len(word2)

	dp := make([][]int, m+1)
	for i := range dp {
		dp[i] = make([]int, n+1)
	}

	// 初始化动作. important 因为增加1为空位，所以需要初始化 dp[0][0] -> dp[0][j] 的步骤
	for i := 0; i < m+1; i++ {
		dp[i][0] = i
	}

	for j := 0; j < n+1; j++ {
		dp[0][j] = j
	}

	for i := 1; i < m+1; i++ {
		for j := 1; j < n+1; j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1])
			}
		}
	}

	return dp[m][n]
}
