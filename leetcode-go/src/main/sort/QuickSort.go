package sort

// QuickSort 快速排序
func QuickSort(nums []int, low, high int) {
	if low >= high {
		return
	}

	index := partition(nums, low, high)
	QuickSort(nums, low, index)
	QuickSort(nums, index+1, high)
}

// partition 切分，取一个合适的值切分数组，使数组在对应相对区域内排序
func partition(nums []int, low int, high int) int {
	//取 nums[low] 作为切分元素
	s := low
	povitValue := nums[low]

	for low < high {
		// 从数组的右端向左扫描找到第一个小于它的元素
		for low < high && nums[high] >= povitValue {
			high--
		}

		// 从数组的左端向右扫描直到找到第一个大于等于它的元素
		for low < high && nums[low] <= povitValue {
			low++
		}

		// 交换这两个元素
		if low < high {
			nums[low] = nums[high] ^ nums[low]
			nums[high] = nums[low] ^ nums[high]
			nums[low] = nums[high] ^ nums[low]
		}

		// 不断进行这个过程，就可以保证左指针 low 的左侧元素都不大于切分元素， 右指针 high 的右侧元素都不小于切分元素。
	}

	// 当两个指针相遇时，将切分元素 nums[low] 和 nums[high] 交换位置。
	nums[s] = nums[low]
	nums[high] = povitValue
	return low
}
