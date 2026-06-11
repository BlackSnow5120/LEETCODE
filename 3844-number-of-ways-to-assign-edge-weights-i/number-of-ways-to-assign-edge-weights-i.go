func assignEdgeWeights(edges [][]int) int {
	n := len(edges) + 1
	graph := make([][]int, n+1)

	for _, e := range edges {
		u, v := e[0], e[1]

		graph[u] = append(graph[u], v)
		graph[v] = append(graph[v], u)
	}
	type Pair struct {
		node  int
		depth int
	}

	stack := []Pair{{1, 0}}

	visited := make([]bool, n+1)

	visited[1] = true

	maxDepth := 0

	for len(stack) > 0 {
		curr := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		if curr.depth > maxDepth {
			maxDepth = curr.depth
		}
		for _, i := range graph[curr.node] {
			if !visited[i] {
				visited[i] = true
				stack = append(stack, Pair{i, curr.depth + 1})
			}
		}
	}

const MOD = 1000000007
result := 1

// Instead of result <<= 1 (which overflows), 
// we multiply by 2 and mod at every step.
for i := 0; i < maxDepth-1; i++ {
    result = (result * 2) % MOD
}

return result

}