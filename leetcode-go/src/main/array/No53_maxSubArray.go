package array

// MaxSubArray 最大子序和
// 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
// 使用动态规划，把问题看作第 i 个数字结尾的最大连续子数组和
// 因此我们只需要求出每个位置的 f(i)f(i)，然后返回 f 数组中的最大值即可。
// 状态转移方程： f(i)=max{f(i−1)+nums[i],nums[i]}
func MaxSubArray(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
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

// maxSubArray1 不使用DP，模拟的方式
// 记录最大的子序 maxSum, 使用 res 来记录从 p 的位置开始，> maxSum 的数值， 若 < 0 则复位为 0
func maxSubArray1(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}

	maxSum, res, p := nums[0], 0, 0
	for ; p < len(nums); p++ {
		res += nums[p]
		if res > maxSum {
			maxSum = res
		}

		if res < 0 {
			res = 0
		}
	}

	return maxSum
}
