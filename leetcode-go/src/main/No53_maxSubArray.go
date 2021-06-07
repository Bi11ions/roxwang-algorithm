package main

// MaxSubArray 最大子序和
// 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
// 使用动态规划，把问题看作第 i 个数字结尾的最大连续子数组和
// 因此我们只需要求出每个位置的 f(i)f(i)，然后返回 f 数组中的最大值即可。
// 状态转移方程： f(i)=max{f(i−1)+nums[i],nums[i]}
func MaxSubArray(nums []int) int {
	if nil == nums {
		return 0
	}

	maxSum := nums[0]
	for i, n := 1, len(nums); i < n; i++ {
		if nums[i]+nums[i-1] > nums[i] {
			nums[i] += nums[i-1]
		}

		if nums[i] > maxSum {
			maxSum = nums[i]
		}
	}

	return maxSum
}
