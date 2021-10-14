package array

import "main/sort"

// FindKthLargest 无序数组中寻找第 k 个元素
func FindKthLargest(nums []int, k int) int {
	sort.QuickSort3Way(nums, 0, len(nums)-1)
	return nums[k-1]
}
