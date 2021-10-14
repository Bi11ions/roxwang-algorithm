package array

// TwoSum 两数之和
// 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
// 你可以按任意顺序返回答案。
// ① 暴力双循环
// ② Hash表的方式
func TwoSum(nums []int, target int) []int {
	if nil == nums || len(nums) < 2 {
		return nil
	}

	// 使用 Hash 表的方式
	// 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)O(N) 降低到 O(1)O(1)。
	// 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
	hashMap := make(map[int]int, 0)
	for i, x := range nums {
		if p, ok := hashMap[target-x]; ok {
			return []int{p, i}
		}

		hashMap[x] = i
	}

	return nil
}
