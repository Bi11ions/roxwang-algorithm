package string

// MinWindow 最小覆盖子串
// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
// 注意：
//	对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//	如果 s 中存在这样的子串，我们保证它是唯一的答案。
func MinWindow(s string, t string) string {
	if s == "" || t == "" {
		return ""
	}

	var tFreq, sFreq [256]int
	result, left, right, finalLeft, finalRight, minW, count := "", 0, -1, -1, -1, len(s)+1, 0

	for i := 0; i < len(t); i++ {
		tFreq[t[i]-'a']++
	}

	for left < len(s) {
		if right+1 < len(s) && count < len(t) {
			sFreq[s[right+1]-'a']++
			if sFreq[s[right+1]-'a'] <= tFreq[s[right+1]-'a'] {
				count++
			}

			right++
		} else {
			if right-left+1 < minW && count == len(t) {
				minW = right - left + 1
				finalLeft = left
				finalRight = right
			}

			if sFreq[s[left]-'a'] == tFreq[s[left]-'a'] {
				count--
			}

			sFreq[s[left]-'a']--
			left++
		}
	}

	if finalRight != -1 {
		result = s[finalLeft : finalRight+1]
	}

	return result
}
