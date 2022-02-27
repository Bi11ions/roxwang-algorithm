package dp

// CanPartition
// 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
// nums = [1,5,11,5] -> [1, 5, 5], [11] : true
// nums = [1,2,3,5] : false
func CanPartition(nums []int) bool {
	length := len(nums)
	if length < 2 {
		return false
	}

	sum := 0
	for _, num := range nums {
		sum += num
	}

	//若 sum%2 != 0, 则不满足分裂成两个子集
	if sum%2 != 0 {
		return false
	}

	// 使用 dp[target][length]来记录状态
	target, dp := sum/2, make([][]bool, length)
	for i := range dp {
		dp[i] = make([]bool, target+1)
	}

	// 若不选取任何正整数，那么被选取的数为0，对于所有 0 <= i < n, 都有 dp[i][0] = true
	for i := 0; i < length; i++ {
		dp[i][0] = true
	}

	// 当 i = 0 时， 对于 dp[0][nums[0]] = true
	dp[0][nums[0]] = true

	// 当 i > 0 && j > 0 时，状态转移方程如下
	// j >= nums[i] => dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
	// j < nums[i] => dp[i][j] = dp[i-1][j]
	for i := 1; i < length; i++ {
		for j := 1; j <= target; j++ {
			if j >= nums[i] {
				dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
			} else {
				dp[i][j] = dp[i-1][j]
			}
		}

		if dp[i][target] {
			return true
		}
	}

	return dp[length-1][target]
}

// CanPartition2
// 由于此时每一行的 dp 值都只与上一行的 dp 值有关，所以算法可以进一步优化为一维数组
// 状态转移方程为：dp[j] = dp[j] | dp[j-num[i]]
// 此时需要从右往左计算，如果从左往右，则取到dp[j-nums[i]]的值是被更新过的
func CanPartition2(nums []int) bool {
	length := len(nums)
	if length < 2 {
		return false
	}

	sum := 0
	for _, num := range nums {
		sum += num
	}

	//若 sum%2 != 0, 则不满足分裂成两个子集
	if sum%2 != 0 {
		return false
	}

	// 使用 dp[target][length]来记录状态
	target, dp := sum/2, make([]bool, sum/2+1)
	for i := 0; i <= target; i++ {
		dp[i] = i == nums[0]
	}

	for i := 1; i < length; i++ {
		for j := target; j >= nums[i]; j-- {
			dp[j] = dp[j] || dp[j-nums[i]]
		}

		if dp[target] {
			return true
		}
	}

	return dp[target]
}
