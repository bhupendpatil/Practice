## Hill Climbing

```
HillClimbing()
	node <- start
	newNode <- Head(Sort/h (MoveGen(node)))
	while h(newNode) < h(node)
		do node <- newNode
			newNode <- Head(Sort/h (MOdeGen(node)))
	return newNode
```