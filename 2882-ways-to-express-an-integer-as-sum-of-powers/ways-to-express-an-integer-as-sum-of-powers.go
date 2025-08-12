const MOD int64 = 1000000007

func numberOfWays(n int, x int) int {
    powers := []int{}
    for i := 1; ; i++ {
        p := 1
        for k := 0; k < x; k++ {
            p *= i
        }
        if p > n {
            break
        }
        powers = append(powers, p)
    }

    dp := make([]int64, n+1)
    dp[0] = 1

    for _, p := range powers {
        for s := n; s >= p; s-- {
            dp[s] = (dp[s] + dp[s-p]) % MOD
        }
    }
    return int(dp[n])
}