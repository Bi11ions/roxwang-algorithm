package array

// Rotate 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
// 输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
func Rotate(nums []int, k int) {
	method1(nums, k)
}

// 通用解法 时间复杂度 O(n) 空间复杂度 O(n)
func method1(nums []int, k int) {
	length := len(nums)
	newNums := make([]int, length)
	for i, v := range nums {
		newNums[(i+k)%length] = v
	}

	copy(nums, newNums)
}

// 数组翻转 时间复杂度 O(2n) -> O(n) 空间复杂度 O(1)
// 原始数组	1 2 3 4 5 6 7
//翻转所有元素	7 6 5 4 3 2 1
//翻转 [0,k mod n−1] 区间的元素	5 6 7 4 3 2 1
//翻转 [k mod n,n−1] 区间的元素	5 6 7 1 2 3 4
func method2(nums []int, k int) {
	k %= len(nums)
	reverse(nums)
	reverse(nums[:k])
	reverse(nums[k:])
}

func reverse(a []int) {
	for i, n := 0, len(a); i < n/2; i++ {
		a[i], a[n-1-i] = a[n-1-i], a[i]
	}
}
