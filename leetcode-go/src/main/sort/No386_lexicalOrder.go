package sort

// LexicalOrder 给定一个整数 n, 返回从 1 到 n 的字典顺序。
//例如， 给定 n =13，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
func LexicalOrder(n int) []int {
	res := make([]int, 0, n)
	dfs386(1, n, &res)
	return res
}

// dfs386 dfs 暴力解
// 字典排序
//   	 0
//  	/ \
// 	   1   2
//    / \  / \
//   11 12 21 22
func dfs386(x, n int, res *[]int) {
	limit := (x + 10) / 10 * 10
	for x <= n && x < limit {
		*res = append(*res, x)
		if x*10 <= n {
			dfs386(x*10, n, res)
		}

		x++
	}
}
