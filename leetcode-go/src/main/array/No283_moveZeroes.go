package array

// MoveZeroes 移动零
// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序.
// 输入: [0,1,0,3,12]
// 输出: [1,3,12,0,0]
// 说明:
//		1.必须在原数组上操作，不能拷贝额外的数组。
//		2.尽量减少操作次数。
func MoveZeroes(nums []int) {
	// 这一题可以只扫描数组一遍，不断的用 i，j 标记 0 和非 0 的元素，然后相互交换，最终到达题目的目的 。
	// 与这一题相近的题目有第 26 题，第 27 题，第 80 题。
	if len(nums) == 0 {
		return
	}

	j := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			if i != j {
				nums[i], nums[j] = nums[j], nums[i]
			}

			j++
		}
	}
}
