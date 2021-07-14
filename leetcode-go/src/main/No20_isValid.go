package main

// IsValid 有效的括号
// 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
// 有效字符串需满足：
// 		左括号必须用相同类型的右括号闭合。
// 		左括号必须以正确的顺序闭合
func IsValid(s string) bool {
	length := len(s)
	if length%2 != 0 {
		return false
	}

	pairs := map[byte]byte{
		')': '(',
		']': '[',
		'}': '{',
	}

	var stack []byte
	for i := 0; i < length; i++ {
		if pairs[s[i]] > 0 {
			if len(stack) == 0 || stack[len(stack)-1] != pairs[s[i]] {
				return false
			}

			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, s[i])
		}
	}

	return len(stack) == 0
}
