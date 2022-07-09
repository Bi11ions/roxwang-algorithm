package array

// SingleNumber 只出现一次的数字
// 给定非空数组中只有一个数字是出现一次，其余数字均出现两次，找出出现一次的数字并返回
func SingleNumber(nums []int) int {
	// 使用位运算，使用异或运算
	// 任何数和 0 做异或运算，结果仍然是原来的数 即 a ^ 0 = a
	// 任何数和其自身做异或运算，结果是 0， 即 a ^ a = 0
	// 异或运算满足交换律和结合律，即 a ^ b ^ a = b ^ a ^ a = b ^ (a ^ a) = b ^ 0 = b

	single := 0
	for _, num := range nums {
		single ^= num
	}

	return single
}

func singleNumber_hash(nums []int) int {
	numCountMap := make(map[int]int, len(nums))
	for _, num := range nums {
		if _, found := numCountMap[num]; !found {
			numCountMap[num] = 1
			continue
		}

		numCountMap[num]++
	}

	for k, v := range numCountMap {
		if v == 1 {
			return k
		}
	}

	return -1
}
