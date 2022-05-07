package trace

// Exist 单词搜索 使用回溯思想
// 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED" -> 输出：true
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成
type pair struct {
	x, y int
}

func Exist(board [][]byte, word string) bool {
	// 四个方向
	var directions = []pair{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}
	h, w := len(board), len(board[0])
	// 记录访问过的位置
	visited := make([][]bool, h)
	for i := range visited {
		visited[i] = make([]bool, w)
	}

	var check func(i, j, k int) bool
	check = func(i, j, k int) bool {
		// 剪枝：当前字符串不匹配
		if board[i][j] != word[k] {
			return false
		}

		// 单词存在于网格中
		if k == len(word)-1 {
			return true
		}

		visited[i][j] = true
		// 回溯时，还原已访问的单元格
		defer func() { visited[i][j] = false }()
		for _, dir := range directions {
			if newI, newJ := i+dir.x, j+dir.y; 0 <= newI && newI < h && 0 <= newJ && newJ < w && !visited[newI][newJ] {
				if check(newI, newJ, k+1) {
					return true
				}
			}
		}

		return false
	}

	for i, row := range board {
		for j := range row {
			if check(i, j, 0) {
				return true
			}
		}
	}

	return false
}
