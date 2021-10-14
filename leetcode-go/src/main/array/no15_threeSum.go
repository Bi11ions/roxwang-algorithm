package array

import (
	"sort"
)

// ThreeSum 三数和
// 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
func ThreeSum(nums []int) [][]int {
	if nil == nums || len(nums) < 3 {
		return [][]int{}
	}

	n := len(nums)
	sort.Ints(nums)
	ans := make([][]int, 0)
	// a + b + c == 0
	// a
	for first := 0; first < n; first++ {
		// 需要和上一次枚举的数不同
		if first > 0 && nums[first] == nums[first-1] {
			continue
		}

		// c 对应的指针初始化指向数组的最右端
		third := n - 1
		target := -1 * nums[first]
		// b
		for second := first + 1; second < n; second++ {
			// 需要和上一次枚举的数不同
			if second > first+1 && nums[second] == nums[second-1] {
				continue
			}

			// 要保证 b 的指针在 c 的指针右侧
			for second < third && nums[second]+nums[third] > target {
				third--
			}

			if second == third {
				break
			}

			if nums[second]+nums[third] == target {
				ans = append(ans, []int{nums[first], nums[second], nums[third]})
			}
		}
	}

	return ans
}
