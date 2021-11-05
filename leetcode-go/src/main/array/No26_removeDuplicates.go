package array

// RemoveDuplicates 删除有序数组中重复项
// 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
func RemoveDuplicates(nums []int) int {
	if len(nums) < 2 {
		return len(nums)
	}

	// 数组有序; 若无序，先排序
	//last, finder := 0, 0
	//for last < len(nums) - 1 {
	//	for nums[finder] == nums[last] {
	//		finder++
	//		if finder == len(nums) {
	//			return last + 1
	//		}
	//	}
	//
	//	nums[last + 1] = nums[finder]
	//	last++
	//}

	// 标记不同数字的个数
	last := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != nums[last] {
			// 放在第一个不同数字后面
			last++
			nums[last] = nums[i]
		}
	}

	return last + 1
}
