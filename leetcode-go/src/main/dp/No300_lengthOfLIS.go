package dp

// LengthOfLIS 最长递增子序列
// 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
// 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
// 状态转移方程：dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
// length = max(dp[i]),其中0≤i<n
// 复杂度 O(n^2)，优化至复杂度 O(n * logn) 见lengthOfLISInDPAndDichotomy(),动态规划+二分法
func LengthOfLIS(nums []int) int {
	n := len(nums)
	if n < 2 {
		return 1
	}

	dp := make([]int, n)
	dp[0] = 1
	length := 1
	for i := 1; i < n; i++ {
		dp[i] = 1
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] {
				dp[i] = max(dp[j], dp[j]+1)
			}
		}

		length = max(length, dp[i])
	}

	return length
}
