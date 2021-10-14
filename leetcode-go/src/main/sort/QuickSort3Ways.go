package sort

// QuickSort3Way 快排-三向切分法
// 三向切分。前后各俩指针，总共四个指针。俩额外的指针指向跟待选元素相同的元素，最后全部置换到中间。
// 优点：重复率高的时候，避免相同元素来回交换，节省交换次数。对于包含大量重复元素的数组，这个算法将排序时间从线性对数级降到了线性级别。
// 三向切分最坏的情况就是所有的主键都不相同，当存在重复键的时候，它的性能就会比归并好得多。
func QuickSort3Way(nums []int, low, high int) {
	if low >= high {
		return
	}

	lt, i, gt := low, low+1, high
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

	QuickSort3Way(nums, low, lt-1)
	QuickSort3Way(nums, gt+1, high)
}
