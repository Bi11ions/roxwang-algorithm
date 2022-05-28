package String

// StrStr 实现strStr()函数。
//
//给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
//说明：
//当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
// 输入：haystack = "hello", needle = "ll"
// 输出：2
func StrStr(haystack string, needle string) int {
	// KMP 算法
	n, m := len(haystack), len(needle)
	if m == 0 {
		return -1
	}

	pi := make([]int, m)
	for i, j := 1, 0; i < m; i++ {
		for j > 0 && needle[i] != needle[j] {
			j = pi[j-1]
		}

		if needle[i] == needle[j] {
			j++
		}

		pi[i] = j
	}

	for i, j := 0, 0; i < n; i++ {
		for j > 0 && haystack[i] != needle[j] {
			j = pi[j-1]
		}

		if haystack[i] == needle[j] {
			j++
		}

		if j == m {
			return i - m + 1
		}
	}

	return -1
}
