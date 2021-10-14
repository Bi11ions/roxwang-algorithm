package string

// FindAnagrams 找到字符串中所有字母异位词
// 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
// 异位词 指字母相同，但排列不同的字符串。
func FindAnagrams(s string, p string) []int {
	// 窗口大小
	var freq [256]int
	var result []int

	if len(s) == 0 || len(s) < len(p) {
		return result
	}

	for i := 0; i < len(p); i++ {
		freq[p[i]-'a']++
	}

	// 左右指针
	// 解法也是用 freq[256] 记录每个字符的出现的频次次数。
	// 滑动窗口左边界往右滑动的时候，划过去的元素释放次数(即次数 ++)，
	// 滑动窗口右边界往右滑动的时候，划过去的元素消耗次数(即次数 --)。
	left, right, count := 0, 0, len(p)
	for right < len(s) {
		// 具体做法是每经过一个符合规范的元素，count 就 --
		if freq[s[right]-'a'] >= 1 {
			count--
		}

		freq[s[right]-'a']--
		right++
		// count 初始值是 len(p)，当每个元素都符合规范的时候，右边界和左边界相差 len(p) 的时候，count 也会等于 0
		if count == 0 {
			result = append(result, left)
		}

		// 当区间内有不符合规范的元素(freq < 0 或者是不存在的元素)，
		// 那么当区间达到 len(p) 的时候，count 无法减少到 0，区间右移动的时候，左边界又会开始 count ++，
		// 只有当左边界移出了这些不合规范的元素以后，才可能出现 count = 0 的情况
		if right-left == len(p) {
			// 向右移动并增加 count
			if freq[s[left]-'a'] >= 0 {
				count++
			}

			freq[s[left]-'a']++
			left++
		}
	}

	return result
}
