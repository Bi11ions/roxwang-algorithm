package String

// 计算器
func calculate2(s string) int {
	ans := 0
	stack := []int{}
	preSign := '+'
	num := 0
	for i, ch := range s {
		isDigit := '0' <= ch && ch <= '9'
		if isDigit {
			num = num*10 + int(ch-'0')
		}

		if !isDigit && ch != ' ' || i == len(s)-1 {
			switch preSign {
			case '+':
				stack = append(stack, num)
			case '-':
				stack = append(stack, -num)
			case '*':
				stack[len(stack)-1] *= num
			default:
				stack[len(stack)-1] /= num
			}
		}

		preSign = ch
		num = 0
	}

	for _, v := range stack {
		ans += v
	}

	return ans
}

// 由于乘除优先于加减计算，因此不妨考虑先进行所有乘除运算，并将这些乘除运算后的整数值放回原表达式的相应位置，则随后整个表达式的值，就等于一系列整数加减后的值。
//
//基于此，我们可以用一个栈，保存这些（进行乘除运算后的）整数的值。
//对于加减号后的数字，将其直接压入栈中；
//对于乘除号后的数字，可以直接与栈顶元素计算，并替换栈顶元素为计算后的结果。
//
//具体来说，遍历字符串 ss，并用变量 preSign 记录每个数字之前的运算符，对于第一个数字，其之前的运算符视为加号。每次遍历到数字末尾时，根据 preSign 来决定计算方式：
//
//加号：将数字压入栈；
//减号：将数字的相反数压入栈；
//乘除号：计算数字与栈顶元素，并将栈顶元素替换为计算结果。
//代码实现中，若读到一个运算符，或者遍历到字符串末尾，即认为是遍历到了数字末尾。处理完该数字后，更新 preSign 为当前遍历的字符。
//
//遍历完字符串 ss 后，将栈中元素累加，即为该字符串表达式的值。
