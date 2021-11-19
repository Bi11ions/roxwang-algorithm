package array

// MaxSlidingWindow 滑动窗口的最大值
// 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。返回滑动窗口最大值。
// 思路：
// 1.给定一个数组和一个窗口为 K 的窗口，当窗口从数组的左边滑动到数组右边的时候，输出每次移动窗口以后，在窗口内的最大值。
// 2.这道题最暴力的方法就是 2 层循环，时间复杂度 O(n * K)。
// 3.另一种思路是用优先队列，每次窗口以后的时候都向优先队列里面新增一个节点，并删除一个节点。时间复杂度是 O(n * log n)
// 4.最优的解法是用双端队列，队列的一边永远都存的是窗口的最大值，队列的另外一个边存的是比最大值小的值。队列中最大值左边的所有值都出队。在保证了双端队列的一边即是最大值以后，时间复杂度是 O(n)，空间复杂度是 O(K)
func MaxSlidingWindow(nums []int, k int) []int {
	return maxSlidingWindowDQueue(nums, k)
}

// maxSlidingWindowDQueue 双端队列
func maxSlidingWindowDQueue(nums []int, k int) []int {
	if len(nums) == 0 || len(nums) < k {
		return []int{}
	}

	windows := make([]int, 0, k) // 存放下标值
	result := make([]int, 0, len(nums)-k+1)

	for i, v := range nums {
		// 如果最左边的索引被已经不在窗口索引范围内，则移出
		if i >= k && windows[0] <= i-k {
			windows = windows[1:]
		}

		// 如果当前窗口最右边的值小于当前下表i对应的值，那么删除最右边的索引，加入当前下标i，保持窗口大小
		for len(windows) > 0 && nums[windows[len(windows)-1]] < v {
			windows = windows[0 : len(windows)-1]
		}

		// 将索引放入窗口中
		windows = append(windows, i)
		if i >= k-1 {
			// 窗口最左边的就是当前窗口最大值
			result = append(result, nums[windows[0]])
		}
	}

	return result
}

// maxSlidingWindowDoubleLoop 暴力解法
func maxSlidingWindowDoubleLoop(nums []int, k int) []int {
	res := make([]int, 0, k)
	n := len(nums)
	if n == 0 {
		return []int{}
	}

	for i := 0; i < n-k; i++ {
		max := nums[i]
		for j := 1; j < k; j++ {
			if max < nums[i+j] {
				max = nums[i+j]
			}
		}

		res = append(res, max)
	}

	return res
}
