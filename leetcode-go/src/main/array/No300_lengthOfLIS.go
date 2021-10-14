package array

// LengthOfLIS 最长递增子序列
// 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
// 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
func LengthOfLIS(nums []int) int {
	return lengthOfLISInDPAndDichotomy(nums)
}

// 动态规划 + 二分法
// 降低复杂度切入点： 解法一中，遍历计算 dp 列表需 O(N)，计算每个 dp[k] 需 O(N)。
// 		动态规划中，通过线性遍历来计算 dp 的复杂度无法降低；
// 		每轮计算中，需要通过线性遍历 [0,k) 区间元素来得到 dp[k]。
// 			我们考虑：是否可以通过重新设计状态定义，使整个 dp 为一个排序列表；
// 					这样在计算每个 dp[k] 时，就可以通过二分法遍历 [0,k) 区间元素，将此部分复杂度由 O(N) 降至 O(logN)。
// 设计思路：
// 	新的状态定义：
// 		我们考虑维护一个列表 tails，其中每个元素 tails[k] 的值代表 长度为 k+1 的子序列尾部元素的值。
// 		如 [1,4,6] 序列，长度为 1,2,3 的子序列尾部元素值分别为 tails = [1,4,6]。
// 	状态转移设计：
// 		设常量数字 N，和随机数字 x，我们可以容易推出：当 N 越小时，N<x 的几率越大。例如： N=0 肯定比 N=1000 更可能满足 N<x。
// 		在遍历计算每个 tails[k]，不断更新长度为 [1,k] 的子序列尾部元素值，始终保持每个尾部元素值最小 （例如 [1,5,3]， 遍历到元素 5 时，
// 		长度为 2 的子序列尾部元素值为 5；当遍历到元素 3 时，尾部元素值应更新至 3，因为 3 遇到比它大的数字的几率更大）。
// 	tails 列表一定是严格递增的： 即当尽可能使每个子序列尾部元素值最小的前提下，子序列越长，其序列尾部元素值一定更大。
// 		反证法证明： 当 k < i，若 tails[k] >= tails[i]，代表较短子序列的尾部元素的值 > 较长子序列的尾部元素的值。这是不可能的，
// 			因为从长度为 i 的子序列尾部倒序删除 i-1 个元素，剩下的为长度为 k 的子序列，
// 			设此序列尾部元素值为 v，则一定有 v<tails[i] （即长度为 k 的子序列尾部元素值一定更小）， 这和 tails[k]>=tails[i] 矛盾。
// 		既然严格递增，每轮计算 tails[k] 时就可以使用二分法查找需要更新的尾部元素值的对应索引 i。

// 算法流程：
// 状态定义：
// 		tails[k] 的值代表 长度为 k+1 子序列 的尾部元素值。
// 转移方程： 设 res 为 tails 当前长度，代表直到当前的最长上升子序列长度。
// 		设 j∈[0,res)，考虑每轮遍历 nums[k] 时，通过二分法遍历 [0,res) 列表区间，找出 nums[k] 的大小分界点，会出现两种情况：
// 		1. 区间中存在 tails[i] > nums[k] ： 将第一个满足 tails[i] > nums[k] 执行 tails[i] = nums[k] ；因为更小的 nums[k] 后更可能接一个比它大的数字（前面分析过）。
// 		2. 区间中不存在 tails[i] > nums[k] ： 意味着 nums[k] 可以接在前面所有长度的子序列之后，因此肯定是接到最长的后面（长度为 res ），新子序列长度为 res + 1。
//
// 初始状态：
// 		令 tails 列表所有值 =0。
// 返回值：
// 		返回 res ，即最长上升子子序列长度。
// 复杂度分析：
// 		时间复杂度 O(NlogN) ： 遍历 nums 列表需 O(N)，在每个 nums[i] 二分法需 O(logN)。
// 		空间复杂度 O(N) ： tails 列表占用线性大小额外空间。
func lengthOfLISInDPAndDichotomy(nums []int) int {
	length := len(nums)
	if length <= 1 {
		return 1
	}

	res := 0
	tails := make([]int, length)
	for _, num := range nums {
		i, j := 0, res
		for i < j {
			m := i + (j-i)/2
			if tails[m] < num {
				i = m + 1
			} else {
				j = m
			}
		}

		tails[i] = num
		if res == j {
			res++
		}
	}

	return res
}

// 动态规划的方式
// 解题思路：
// 状态定义：
// 		dp[i] 的值代表 nums 前 i 个数字的最长子序列长度。
// 转移方程：
// 设 j∈[0,i)j∈[0,i)，考虑每轮计算新 dp[i] 时，遍历 [0,i) 列表区间，做以下判断：
// 		1. 当 nums[i] > nums[j] 时： nums[i] 可以接在 nums[j] 之后（此题要求严格递增），此情况下最长上升子序列长度为 dp[j] + 1；
//		2. 当 nums[i] <= nums[j] 时： nums[i] 无法接在 nums[j] 之后，此情况上升子序列不成立，跳过。
// 故上述所有
//  情况1下计算出的 dp[j] + 1 的最大值，为直到 i 的最长上升子序列长度（即 dp[i]）。
// 	实现方式为遍历 j 时，每轮执行 dp[i] = max(dp[i], dp[j] + 1)。
// 转移方程： dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)。
// 初始状态：
// 	dp[i] 所有元素置 1，含义是每个元素都至少可以单独成为子序列，此时长度都为 1。
// 返回值：
// 	返回 dp 列表最大值，即可得到全局最长上升子序列长度。
// 复杂度分析：
// 	时间复杂度 O(N^2)： 遍历计算 dp 列表需 O(N)，计算每个 dp[i] 需 O(N)。
// 	空间复杂度 O(N)： dp 列表占用线性大小额外空间。
func lengthOfLISInDP(nums []int) int {
	length := len(nums)
	if length <= 1 {
		return 1
	}

	max := 0
	dp := make([]int, length)
	for i := 0; i < length; i++ {
		dp[i] = 1
	}

	for i := 1; i < length; i++ {
		for j := 0; j < i; j++ {
			if nums[j] < nums[i] {
				if dp[i] < dp[j]+1 {
					dp[i] = dp[j] + 1
				}
			}
		}

		if max < dp[i] {
			max = dp[i]
		}
	}

	return max
}
