package num

// ConversionOfNumSystems 输入一个十进制数M，转换为N进制输出. M<=10^8,2≤N≤16
func ConversionOfNumSystems(M, N int) string {
	// 1.令M ÷ N = m …… q，m为商，q为余数。
	// 2.将q作为新数的最大位，再字符串上表现为添加至字符串左侧。
	// 3.令M = m，并重复整个过程直到M=0。
	// 对于N>10的进制转化，当q≥10时，就需要进行一个转化，与字母表进行一个顺序映射。
	// 最后考虑负数带来的影响，在输入时，我们就可以对符号位进行一个判断，使用一个布尔值存储正负，并将M统一为非负数。
	// 在正数转化完成后，通过布尔值，选择是否在字符串左侧添加一个负号。

	var sign bool
	if M < 0 {
		sign = true
		M = -M
	}

	var res string
	for M > 0 {
		q := M % N
		var b byte
		if q <= 9 {
			b = '0' + byte(q)
		} else {
			b = 'A' + byte(q-10)
		}

		res = string(b) + res
		M /= N
	}

	if sign {
		res = "-" + res
	}

	return res
}
