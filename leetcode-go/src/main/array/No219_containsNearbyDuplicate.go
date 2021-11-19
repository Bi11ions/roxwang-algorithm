package array

// ContainsNearbyDuplicate 存在重复元素 II
// 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
func ContainsNearbyDuplicate(nums []int, k int) bool {
	if nil == nums || len(nums) <= 1 || k < 0 {
		return false
	}

	// 可以维护一个只有 K 个元素的 map，每次只需要判断这个 map 里面是否存在这个元素即可。
	// 如果存在就代表重复数字的下标差值在 K 以内。map 的长度如果超过了 K 以后就删除掉 i-k 的那个元素，
	// 这样一直维护 map 里面只有 K 个元素。
	hashMap := make(map[int]bool, len(nums))
	for i, number := range nums {
		if _, found := hashMap[number]; found {
			return true
		}

		hashMap[number] = true
		if len(hashMap) == k+1 {
			delete(hashMap, nums[i-k])
		}
	}

	return false
}
