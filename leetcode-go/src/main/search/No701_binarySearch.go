package search

// binarySearch 二分查找 如果目标值存在返回下标，否则返回 -1。
func binarySearch(nums []int, target int) int {
	return searchInBinary(nums, 0, len(nums)-1, target)
}

func searchInBinary(nums []int, startIndex, endIndex, target int) int {
	if startIndex >= endIndex {
		if target == nums[startIndex] {
			return startIndex
		}

		return -1
	}

	// 防止数值溢出
	mid := startIndex + (endIndex-startIndex)/2
	if nums[mid] < target {
		return searchInBinary(nums, mid+1, endIndex, target)
	}

	return searchInBinary(nums, startIndex, mid, target)
}
