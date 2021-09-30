package main

// MyAtoi 字符串转换整数 (atoi).  32 位有符号整数范围 [−2^31,  2^31−1]
// "42" -> 42
// "     -42" -> -42
// "4193 with words" -> 4193
// "with words 4193" -> 0
// "-91283472332" -> -2147483648
func MyAtoi(s string) int {
	if len(s) == 0 {
		return 0
	}

	maxInt, signAllowed, whitespaceAllowed, sign, digits := int64(2<<30), true, true, 1, []int{}
	// 将数字存放在 digits 数组中，提取符号
	for _, c := range s {
		if c == ' ' && whitespaceAllowed {
			continue
		}

		if signAllowed {
			if c == '+' {
				signAllowed = false
				whitespaceAllowed = false
				continue
			} else if c == '-' {
				sign = -1
				signAllowed = false
				whitespaceAllowed = false
				continue
			}
		}

		if c < '0' || c > '9' {
			break
		}

		whitespaceAllowed, signAllowed = false, false
		digits = append(digits, int(c-48))
	}

	var num, place, rtnMax int64
	num, place = 0, 1

	lastLeading0Index := -1
	for i, d := range digits {
		if d == 0 {
			lastLeading0Index = i
		} else {
			break
		}
	}

	if lastLeading0Index > -1 {
		digits = digits[lastLeading0Index+1:]
	}

	if sign > 0 {
		rtnMax = maxInt - 1
	} else {
		rtnMax = maxInt
	}

	digitsCount := len(digits)
	for i := digitsCount - 1; i >= 0; i-- {
		num += int64(digits[i]) * place
		place *= 10
		if digitsCount-i > 10 || num > rtnMax {
			return int(int64(sign) * rtnMax)
		}
	}

	num *= int64(sign)
	return int(num)
}
