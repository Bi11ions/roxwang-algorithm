package array

// SearchReverse 搜索旋转数组
// 整数数组 nums 按升序排列，数组中的值 互不相同 。
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
// 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
// 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
func SearchReverse(nums []int, target int) int {
	if nil == nums {
		return -1
	}

	n := len(nums)
	if nums[0] <= target {
		for i := 0; i < n && nums[i] >= nums[0]; i++ {
			if target == nums[i] {
				return i
			}
		}
	} else if n-1 > 0 && nums[n-1] >= target {
		for i := n - 1; i > -1 && nums[i] <= nums[n-1]; i-- {
			if target == nums[i] {
				return i
			}
		}
	}

	return -1
}

// 官方使用二分法，时间复杂度 logN，
func search(nums []int, target int) int {
	n := len(nums)
	if 0 == n {
		return -1
	}

	if 1 == n {
		if target == nums[0] {
			return 0
		}

		return -1
	}

	l, r := 0, n-1
	for l < r {
		mid := l + (r-l)/2
		if nums[mid] == target {
			return mid
		}

		if nums[0] <= nums[mid] {
			// 0 - mid 这一部分是有序的
			// target 在 0 - mid 中，更新有边界为 mid - 1，否则左边界更新为 mid + 1
			if nums[0] <= target && target < nums[mid] {
				r = mid - 1
			} else {
				l = mid + 1
			}
		} else {
			// 旋转点 k 在 0 - mid 中, mid - n - 1 是有序的
			if nums[mid] < target && target <= nums[n-1] {
				l = mid + 1
			} else {
				r = mid - 1
			}
		}
	}

	return -1
}
