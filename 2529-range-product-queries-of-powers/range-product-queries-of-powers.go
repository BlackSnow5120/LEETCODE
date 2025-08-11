func productQueries(n int, queries [][]int) []int {
	const MOD = 1000000007

	// Extract powers of 2 that sum to n
	powers := []int{}
	for i := 0; i <= 31; i++ {
		pow := 1 << i
		if n&pow != 0 {
			powers = append(powers, pow)
		}
	}

	ans := make([]int, 0, len(queries))
	for _, q := range queries {
		L, R := q[0], q[1]
		product := 1
		for i := L; i <= R; i++ {
			product = (product * powers[i]) % MOD
		}
		ans = append(ans, product)
	}

	return ans
}
