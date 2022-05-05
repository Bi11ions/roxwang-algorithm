package array

// Intersection 多个数组求交集
// 给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，按 升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过。
// 输入 nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]] -> 输出: [3,4]
// 1 <= nums.length <= 1000
// 1 <= sum(nums[i].length) <= 1000
// 1 <= nums[i][j] <= 1000
func Intersection(nums [][]int) []int {
	tempLen := 1001
	ans, temp := make([]int, 0), make([]int, tempLen)
	for _, num := range nums {
		for _, n := range num {
			temp[n]++
		}
	}

	for i, n := 0, len(nums); i < tempLen; i++ {
		if temp[i] == n {
			ans = append(ans, i)
		}
	}

	return ans
}
