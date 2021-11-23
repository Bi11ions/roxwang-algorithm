package array

// PlusOne 加一
// 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
func PlusOne(digits []int) []int {
	// 给出一个数组，代表一个十进制数，数组的 0 下标是十进制数的高位。要求计算这个十进制数加一以后的结果。
	// 简单的模拟题。从数组尾部开始往前扫，逐位进位即可。最高位如果还有进位需要在数组里面第 0 位再插入一个 1 。

	for i := len(digits) - 1; i >= 0; i-- {
		digits[i]++
		if digits[i] != 10 {
			return digits
		}

		// carry
		digits[i] = 0
	}

	// 每一位都需要进位时才会走到这里：9999
	digits[0] = 1
	digits = append(digits, 0)
	return digits
}
