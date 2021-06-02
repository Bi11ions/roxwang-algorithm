package main

func MySqrt(x int) int {
	if x == 0 {
		return 0
	}

	// 牛顿迭代法
	// return int(sqrts(float64(x)))

	// 袖珍计算器算法 经过公式变换 x^1/2 = (e^lnx)^1/2 = e^(1/2)*lnx
	// 由于浮点数转为整数时存在误差，所以需要判断 ans 与 ans+1 哪一个是正确答案
	// ans := int(math.Exp(0.5 * math.Log(float64(x))))
	// if (ans + 1) * (ans + 1) <= x {
	// 	return ans + 1
	// }
	//
	// return ans

	// 二分法
	l, r := 0, x
	ans := 1
	for l < r {
		mid := 1 + (r-l)/2
		if mid*mid <= x {
			ans = mid
			l = mid + 1
		} else {
			r = mid - 1
		}
	}

	return ans
}

// 牛顿迭代法
// 这种算法的原理很简单，我们仅仅是不断用 (x, f(x)) 的切线来逼近方程 x^2-a=0 的根。根号 aa 实际上就是 x^2-a= 的一个正实根，
// 这个函数的导数是 2x。也就是说，函数上任一点 (x,f(x)) 处的切线斜率是 2x。
// 那么，x-f(x)/(2x)x−f(x)/(2x) 就是一个比 xx 更接近的近似值。代入 f(x)=x^2-af(x)=x^2 −a 得到 x-(x^2-a)/(2x)x−(x^2 −a)/(2x)，也就是 (x+a/x)/2(x+a/x)/2。
var s int

func sqrts(x float64) float64 {
	res := (x + float64(s)/x) / 2
	if res == x {
		return x
	}

	return sqrts(res)
}
