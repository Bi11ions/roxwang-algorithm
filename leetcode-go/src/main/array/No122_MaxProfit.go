package array

// MaxProfit2 买卖股票的最佳时机
// 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
// 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
// 返回你能获得的最大利润。
func MaxProfit2(prices []int) int {
	return maxProfit2_dp(prices)
}

// maxProfit2_greedy 使用贪心算法. --> 由于不限制交易次数，只要今天股价比昨天高，就交易。
// 由于股票的购买没有限制，因此整个问题等价于寻找 x 个不相交的区间(Li, Ri]使得如下的等式最大化：求和 i = 1 开始到 i = x 时， prices[Ri] - prices[Li]
// 其中 Li 表示在第 Li 天买入，Ri 表示在第 Ri 天卖出。
// ans = ∑ i = 1 -> i = n - 1 区间内，max{0, prices[i] - prices[i-1]}
func maxProfit2_greedy(prices []int) int {
	ans := 0
	for i := 1; i < len(prices); i++ {
		ans += max(0, prices[i]-prices[i-1])
	}

	return ans
}

// maxProfit2_dp 使用动态规划
// 定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）
// 转移方程：dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
//         dp[i][1]=max{dp[i-1][1],dp[i-1][0]-prices[i]}
// 初始值：dp[0][0]=0，dp[0][1] = −prices[0]。
// 因此，我们只要从前往后依次计算状态即可。由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，因此这时候dp[n−1][0] 的收益必然是大于 dp[n−1][1] 的，最后的答案即为 dp[n−1][0]
func maxProfit2_dp(prices []int) int {
	n := len(prices)
	if 0 == n {
		return 0
	}

	dayProfit := make([][2]int, n)
	dayProfit[0][1] = -prices[0]

	for i := 1; i < n; i++ {
		dayProfit[i][0] = max(dayProfit[i-1][0], dayProfit[i-1][1]+prices[i])
		dayProfit[i][1] = max(dayProfit[i-1][1], dayProfit[i-1][0]-prices[i])
	}

	return dayProfit[n-1][0]
}

func max(i, j int) int {
	if i > j {
		return i
	}

	return j
}
