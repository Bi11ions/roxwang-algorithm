package String

import (
	"strconv"
)

// addStrings 字符串相加。
// 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
//你不能使用任何內建的用于处理大整数的库（比如 BigInteger）也不能直接将输入的字符串转换为整数形式。
func addStrings(num1 string, num2 string) string {
	add := 0
	ans := ""
	// 当 x / y 没有遍历完，或者 add!=0 有进位时，还要继续执行
	for i, j := len(num1)-1, len(num2)-1; i >= 0 || j >= 0 || add != 0; i, j = i-1, j-1 {
		var x, y int
		if i >= 0 {
			x = int(num1[i] - '0')
		}

		if j >= 0 {
			y = int(num2[j] - '0')
		}

		result := x + y + add
		ans = strconv.Itoa(result%10) + ans
		add = result / 10
	}

	return ans
}
