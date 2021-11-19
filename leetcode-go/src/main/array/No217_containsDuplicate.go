package array

// ContainsDuplicate 存在重复的元素
// 给定一个整数数组，判断是否存在重复元素。
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
func ContainsDuplicate(nums []int) bool {
	if nil == nums || len(nums) <= 1 {
		return false
	}

	hashMap := make(map[int]int, len(nums))
	for i := 0; i < len(nums); i++ {
		number := nums[i]

		if 1 == hashMap[number] {
			return true
		}

		hashMap[number] = 1
	}

	return false
}
