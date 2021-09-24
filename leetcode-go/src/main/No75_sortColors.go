package main

// SortColors
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
func SortColors(nums []int)  {
	// 由于排序数字少，可以记录 0 和 1 的次数，按照个数排序 0，1，2
	var zero, one int
	for i, n := range nums {
		nums[i] = 2
		if n <= 1 {
			nums[one] = 1
			one++
		}

		if n == 0 {
			nums[zero] = 0
			zero++
		}
	}
}
