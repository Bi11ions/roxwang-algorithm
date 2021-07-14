package main

// SpiralOrder 螺旋矩阵
// 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
// -100 <= matrix[i][j] <= 100
func SpiralOrder(matrix [][]int) []int {
	if nil == matrix {
		return nil
	}

	m, n := len(matrix), len(matrix[0])
	result := make([]int, m*n)
	top, left := 0, 0
	for i := 0; i < m*n; {
		for top < m && left < n && matrix[top][left] != 101 {
			result[i] = matrix[top][left]
			matrix[top][left] = 101
			i++
			left++
		}
		top++
		left--

		for top < m && left < n && matrix[top][left] != 101 {
			result[i] = matrix[top][left]
			matrix[top][left] = 101
			i++
			top++
		}
		left--
		top--

		for left > -1 && top > -1 && matrix[top][left] != 101 {
			result[i] = matrix[top][left]
			matrix[top][left] = 101
			i++
			left--
		}
		top--
		left++

		for top > -1 && matrix[top][left] != 101 {
			result[i] = matrix[top][left]
			matrix[top][left] = 101
			i++
			top--
		}
		left++
		top++
	}

	return result
}

// 官方解法
func spiralOrder(matrix [][]int) []int {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return []int{}
	}
	var (
		rows, columns = len(matrix), len(matrix[0])
		order         = make([]int, rows*columns)
		index         = 0
		// 上下左右四条边，让指针沿着边移动
		left, right, top, bottom = 0, columns - 1, 0, rows - 1
	)

	for left <= right && top <= bottom {
		for column := left; column <= right; column++ {
			order[index] = matrix[top][column]
			index++
		}
		for row := top + 1; row <= bottom; row++ {
			order[index] = matrix[row][right]
			index++
		}
		if left < right && top < bottom {
			for column := right - 1; column > left; column-- {
				order[index] = matrix[bottom][column]
				index++
			}
			for row := bottom; row > top; row-- {
				order[index] = matrix[row][left]
				index++
			}
		}
		left++
		right--
		top++
		bottom--
	}
	return order
}
