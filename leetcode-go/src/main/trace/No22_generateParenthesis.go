package trace

// GenerateParenthesis 括号生成
// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
// 输入：n = 3  -> 输出：["((()))","(()())","(())()","()(())","()()()"]
// 回溯法
// 回溯算法，死抓三点
//	选择
//		在这里，每次最多两个选择，选左括号或右括号，“选择”会展开出一棵解的空间树。
//		用 DFS 遍历这棵树，找出所有的解，这个过程叫回溯。
//	约束条件
//		即，什么情况下可以选左括号，什么情况下可以选右括号。
//		利用约束做“剪枝”，即，去掉不会产生解的选项，即，剪去不会通往合法解的分支。
//		比如()，现在左右括号各剩一个，再选)就成了())，不能让这个错的选择成为选项（不落入递归）：
//			if (right > left) { // 右括号剩的比较多，才能选右括号
//   	 		dfs(str + ')', left, right - 1);
//			}
//	目标
//		构建出一个用尽 n 对括号的合法括号串。
//		意味着，当构建的长度达到 2*n，就可以结束递归（不用继续选了）。
// 充分剪枝的好处
//		经过充分剪枝，所有不会通往合法解的选项都被剪掉，只要往下递归，就都通向合法解。
//		即只要递归到：当构建的字符串的长度为 2*n 时，一个合法解就生成了，放心地加入解集。
func GenerateParenthesis(n int) []string {
	var res []string
	var parenthesisInTrace func(str string, left, right int)
	parenthesisInTrace = func(str string, left, right int) {
		if left == 0 && right == 0 {
			res = append(res, str)
			return
		}

		if left == right {
			// 剩余左右括号相等，下一个只能用左括号
			parenthesisInTrace(str+"(", left-1, right)
		} else {
			// 剩余左括号小于右括号，下一个可以用左括号也可以用右括号
			if left > 0 {
				parenthesisInTrace(str+"(", left-1, right)
			}

			parenthesisInTrace(str+")", left, right-1)
		}
	}

	parenthesisInTrace("", n, n)
	return res
}

// 动态规划
//		f(n) = "(" + f(p) + ")" + f(q). 注:q+p = n-1
// 本题最核心的思想是，考虑 i=n 时相比 n-1 组括号增加的那一组括号的位置。
// 思路：
//		当我们清楚所有 i<n 时括号的可能生成排列后，对与 i=n 的情况，我们考虑整个括号排列中最左边的括号。
//		它一定是一个左括号，那么它可以和它对应的右括号组成一组完整的括号 "( )"，我们认为这一组是相比 n-1 增加进来的括号。
//		那么，剩下 n-1 组括号有可能在哪呢？
//		【这里是重点，请着重理解】
//		剩下的括号要么在这一组新增的括号内部，要么在这一组新增括号的外部（右侧）。
//		既然知道了 i<n 的情况，那我们就可以对所有情况进行遍历： "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
//		其中 p + q = n-1，且 p q 均为非负整数。
//		事实上，当上述 p 从 0 取到 n-1，q 从 n-1 取到 0 后，所有情况就遍历完了。
//		注：上述遍历是没有重复情况出现的，即当 (p1,q1)≠(p2,q2) 时，按上述方式取的括号组合一定不同。
func generateParenthesisInDP(n int) []string {
	return dp(n)[n]
}

func dp(n int) map[int][]string {
	if n == 0 {
		return map[int][]string{0: {""}}
	}

	if n == 1 {
		return map[int][]string{0: {""}, 1: {"()"}}
	}

	lastMap := dp(n - 1)
	var oneRes []string
	for i := 0; i < n; i++ {
		inners := lastMap[i]
		outers := lastMap[n-1-i]
		for _, inner := range inners {
			for _, outer := range outers {
				oneRes = append(oneRes, "("+inner+")"+outer)
			}
		}
	}

	lastMap[n] = oneRes
	return lastMap
}
