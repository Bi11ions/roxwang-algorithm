package array

import "math"

// MaxProfit 买卖股票的最佳时机
// 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
func MaxProfit(prices []int) int {
	n := len(prices)
	if n < 2 {
		return 0
	}

	// 记录最低点，以最低点买入，再以最低点后的最高点卖出
	minPrice := int(math.Pow10(4))
	max := 0
	for i := 0; i < n; i++ {
		if prices[i] < minPrice {
			minPrice = prices[i]
		} else if prices[i]-minPrice > max {
			max = prices[i] - minPrice
		}
	}

	// 暴力破解
	// for salesDay := n - 1; salesDay >= 0 ; salesDay-- {
	// 	for buyDay := 0; buyDay < salesDay; buyDay++ {
	// 		if prices[salesDay] - prices[buyDay] > max {
	// 			max = prices[salesDay] - prices[buyDay]
	// 		}
	// 	}
	// }

	return max
}
