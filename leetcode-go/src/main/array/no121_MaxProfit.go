package array

import "math"

// MaxProfit 买卖股票的最佳时机
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
