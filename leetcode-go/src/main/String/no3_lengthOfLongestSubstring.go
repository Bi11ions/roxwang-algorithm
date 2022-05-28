package String

// LengthOfLongestSubstring 无重复最长字串
// 滑动窗口 - 哈希桶
func LengthOfLongestSubstring(s string) int {
	// Hash 集合，记录每个字符是否出现过
	indexes := make(map[byte]int, len(s))
	right, left, result := 0, 0, 0

	for right < len(s) {
		// 当前右指针指向的值已经在桶中，则需要左指针向右移动，排除已经重复的地址
		if idx, ok := indexes[s[right]]; ok && idx >= left {
			left = idx + 1
		}

		// 将右指针指向的字符记录在桶中
		indexes[s[right]] = right
		right++
		result = max(result, right-left)
	}

	return result
}

func max(x, y int) int {
	if x < y {
		return y
	}

	return x
}
