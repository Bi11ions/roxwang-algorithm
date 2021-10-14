package sort

// SortArray 给你一个整数数组 nums，请你将该数组升序排列。
func SortArray(nums []int) []int {
	QuickSort3Way(nums, 0, len(nums)-1)
	return nums
}
