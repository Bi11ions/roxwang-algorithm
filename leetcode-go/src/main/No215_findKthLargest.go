package main

// FindKthLargest 无序数组中寻找第 k 个元素
func FindKthLargest(nums []int, k int) int {
	FastSort3Ways(nums, 0, len(nums)-1, false)
	return nums[k-1]
}

// FastSort3Ways 快排-三向切分法
func FastSort3Ways(nums []int, lo, hi int, order bool) {
	if hi <= lo {
		return
	}

	lt := lo
	i := lo + 1
	gt := hi
	v := nums[lo]
	for i <= gt {
		cmp := nums[i] - v
		// 改变 >/< 可以控制从到小或者从小到大
		var stateOne, stateTwo bool
		if order {
			stateOne = cmp < 0
			stateTwo = cmp > 0
		} else {
			stateOne = cmp > 0
			stateTwo = cmp < 0
		}

		if stateOne {
			swap(nums, lt, i)
			lt++
			i++
		} else if stateTwo {
			swap(nums, i, gt)
			gt--
		} else {
			i++
		}
	}

	FastSort3Ways(nums, lo, lt-1, order)
	FastSort3Ways(nums, gt+1, hi, order)
}

func swap(nums []int, left, right int) {
	tmp := nums[left]
	nums[left] = nums[right]
	nums[right] = tmp
}
