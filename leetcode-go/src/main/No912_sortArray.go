package main

// SortArray 给你一个整数数组 nums，请你将该数组升序排列。
func SortArray(nums []int) []int {
	quickSort3Way(nums, 0, len(nums) - 1)
	return nums
}

// quickSort3Way 三向切分的快速排序
// 三向切分。前后各俩指针，总共四个指针。俩额外的指针指向跟待选元素相同的元素，最后全部置换到中间。
// 优点：重复率高的时候，避免相同元素来回交换，节省交换次数。对于包含大量重复元素的数组，这个算法将排序时间从线性对数级降到了线性级别。
// 三向切分最坏的情况就是所有的主键都不相同，当存在重复键的时候，它的性能就会比归并好得多。
func quickSort3Way(nums []int, low, high int) {
	if low >= high {
		return
	}

	lt, i, gt := low, low + 1, high
	temp := nums[low]
	for i <= gt {
		if nums[i] < temp {
			nums[lt] = nums[i] ^ nums[lt]
			nums[i] = nums[lt] ^ nums[i]
			nums[lt] = nums[i] ^ nums[lt]
			lt++
			i++
		} else if nums[i] > temp {
			nums[i] = nums[gt] ^ nums[i]
			nums[gt] = nums[i] ^ nums[gt]
			nums[i] = nums[gt] ^ nums[i]
			gt--
		} else {
			i++
		}
	}

	quickSort3Way(nums, low, lt - 1)
	quickSort3Way(nums, gt + 1, high)
}

// quickSort 快速排序
func quickSort(nums []int, low, high int) {
	if low >= high {
		return
	}

	index := partition(nums, low, high)
	quickSort(nums, low, index)
	quickSort(nums, index + 1, high)
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