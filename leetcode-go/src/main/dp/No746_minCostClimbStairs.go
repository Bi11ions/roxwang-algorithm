package dp

// MinCostClimbStairs
// 最小花费爬楼梯
// 状态转移方程：dp[i] = cost[i] + min(dp[i-2], dp[i-1])
// 最终第 n 层的最小花费是 min(dp[n-2], dp[n-1]) 。
func MinCostClimbStairs(cost []int) int {
	dp := make([]int, len(cost)+1)
	dp[0], dp[1] = cost[0], cost[1]
	for i := 2; i < len(cost); i++ {
		dp[i] = cost[i] + min(dp[i-1], dp[i-2])
	}

	return min(dp[len(cost)-1], dp[len(cost)-2])
}

func min(m, n int) int {
	if m >= n {
		return n
	}

	return m
}

// MinCostClimbStairs2 滚动数组，优化辅助空间
// 由于每层的花费只和前两层有关系，所以每次 DP 迭代的时候只需要 2 个临时变量即可。可以用这种方式来优化辅助空间。
func MinCostClimbStairs2(cost []int) int {
	var cur, last int
	for i := 2; i < len(cost)+1; i++ {
		if last+cost[i-1] > cur+cost[i-2] {
			cur, last = last, cur+cost[i-2]
		} else {
			cur, last = last, last+cost[i-1]
		}
	}

	return last
}
