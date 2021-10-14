package array

// NumIsland 岛屿数量
// 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
// 此外，你可以假设该网格的四条边均被水包围。
func NumIsland(grid [][]byte) int {
	if nil == grid || len(grid) == 0 {
		return 0
	}

	nr := len(grid)
	nc := len(grid[0])
	num_island := 0
	for r := 0; r < nr; r++ {
		for c := 0; c < nc; c++ {
			if grid[r][c] == '1' {
				num_island++
				// 将关联的 1 全部置为 0，认为是一个岛屿
				dfsNumsIsland(grid, r, c)
			}
		}
	}

	return num_island
}

// 方式一：深度优先搜索
// 我们可以将二维网格看成一个无向图，竖直或水平相邻的 1 之间有边相连。
// 为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为 1，则以其为起始节点开始进行深度优先搜索。在深度优先搜索的过程中，每个搜索到的 1 都会被重新标记为 0。
// 最终岛屿的数量就是我们进行深度优先搜索的次数。
func dfsNumsIsland(grid [][]byte, r, c int) {
	nr := len(grid)
	nc := len(grid[0])

	if r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0' {
		return
	}

	grid[r][c] = '0'
	// 上
	dfsNumsIsland(grid, r-1, c)
	// 下
	dfsNumsIsland(grid, r+1, c)
	// 左
	dfsNumsIsland(grid, r, c-1)
	// 右
	dfsNumsIsland(grid, r, c+1)
}
