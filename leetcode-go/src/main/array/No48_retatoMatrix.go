package array

// RotateMatrix 顺时针旋转矩阵90°
func RotateMatrix(matrix [][]int) {
	// matrix[i][j] -> matrix[j][length-1-i]
	// 90° = 水平翻转+主对角线翻转
	horizontalFlip(matrix)
	masterDiagonalLineFlip(matrix)
	// 180° = 副对角线翻转 + 主对角线翻转
	//sideDiagonalLineFlip(matrix)
	//masterDiagonalLineFlip(matrix)
	// 270° = 主对角线翻转+水平翻转
	//masterDiagonalLineFlip(matrix)
	//horizontalFlip(matrix)

	println(matrix)
}

// 横向翻转
func verticalFlip(matrix [][]int) {
	n := len(matrix)
	for i := 0; i < n; i++ {
		for j := 0; j < n/2; j++ {
			matrix[i][j], matrix[i][n-1-j] = matrix[i][n-1-j], matrix[i][j]
		}
	}
}

// 水平翻转
func horizontalFlip(matrix [][]int) {
	n := len(matrix)
	for i := 0; i < n/2; i++ {
		matrix[i], matrix[n-1-i] = matrix[n-1-i], matrix[i]
	}
}

// 主对角线翻转
func masterDiagonalLineFlip(matrix [][]int) {
	n := len(matrix)
	for i := 0; i < n; i++ {
		for j := 0; j < i; j++ {
			matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
		}
	}
}

// 副对角线翻转
func sideDiagonalLineFlip(matrix [][]int) {
	n := len(matrix)
	for i := 0; i < n; i++ {
		for j := 0; j < n-1-i; j++ {
			matrix[i][j], matrix[n-1-j][n-1-i] = matrix[n-1-j][n-1-i], matrix[i][j]
		}
	}
}
