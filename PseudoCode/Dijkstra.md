## Dijkstra's Algorithm
```
DijkstrasAlgorithm()
	colour all nodes white
	cost(start) <- 0
	parent(node) <- NIL
	for all other nodes n
		do cost(n) <- ∞
	repeat
		Select lowesr cost white node n
		Color n black
		for all white neighbours m of n
			do if (cost(n) + k(n,m)) < cost(m)
				then cost(m) <- cost(n) + k(n,m)
					parent(m) <- n
		until all nodes are coloured black
```