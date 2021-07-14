package main

// permute 全排列
// 　回溯法
// 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
func permute(nums []int) [][]int {
	res := make([][]int, 0)
	path := make([]int, 0)
	used := map[int]bool{}

	var dfs func()
	dfs = func() {
		if len(path) == len(nums) {
			temp := make([]int, len(path))
			copy(temp, path)
			res = append(res, temp)
			return
		}

		for _, n := range nums {
			if used[n] {
				continue
			}

			path = append(path, n)
			used[n] = true
			dfs()
			path = path[:len(path)-1]
			used[n] = false
		}
	}

	dfs()
	return res
}
