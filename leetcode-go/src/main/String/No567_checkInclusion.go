package String

// CheckInclusion 字符串的排列. No438 的缩水版
// 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
// 换句话说，s1 的排列之一是 s2 的 子串 。
func CheckInclusion(s1 string, s2 string) bool {
	var freq [256]int

	if len(s2) == 0 || len(s2) < len(s1) {
		return false
	}

	for i := 0; i < len(s1); i++ {
		freq[s1[i]-'a']++
	}

	left, right, count := 0, 0, len(s1)
	for right < len(s2) {
		// 符合时
		if freq[s2[right]-'a'] >= 1 {
			count--
		}

		freq[s2[right]-'a']--
		right++
		if count == 0 {
			return true
		}

		if right-left == len(s1) {
			if freq[s2[left]-'a'] >= 0 {
				count++
			}

			freq[s2[left]-'a']++
			left++
		}
	}

	return false
}
