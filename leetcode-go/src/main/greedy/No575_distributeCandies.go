package greedy

// DistributeCandies 分糖果
// 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的 最多 种类数。
// candyType = [1,1,2,2,3,3] -> 输出：3
// n == candyType.length
// 2 <= n <= 104
// n 是一个偶数
// -105 <= candyType[i] <= 105
func DistributeCandies(candyType []int) int {
	hashMap := make(map[int]int, 0)
	n := len(candyType)
	length := n / 2
	for _, num := range candyType {
		hashMap[num] = 1
	}

	mapSize := len(hashMap)
	if length < mapSize {
		return length
	}

	return mapSize
}
