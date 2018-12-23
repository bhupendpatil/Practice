```
DeptFirstSearch()
	open <- ((start NIL))
	close <- ()
	while not Null(open)
		do nodePair <- Head(open)
			node <- Head(nodePair)
			if GoalTest(node) = TRUE
				then return ReconstrustPath(nodePair, closed)
				else closed <- Cons(nodePair, closed)
					children <- MoveGen(node)
					noLoops <- RemoveSeen(children,open,closed)
					new <- MakePairs(noLoops,node)
					open <- Append(new, Tail(open))
	return "No solution found"
```

```
RemoveSeen(nodeList,openList,closedList)
	if Null(nodeList)
		then return ()
		else n <- Head(nodeList)
			if (OccursIn(n,openList) OR OccursIn(n,closedList))
				then return RemoveSeen(Tail(nodeList),openList,closedList)
				else return Cons(n, RemoveSeen(Tail(nodeList),openList,closedList))
```

```
OccursIn(node, listOfPairs)
	if Null(listOfPairs)
		then return False
		else if n <- Head(Head(listOfPairs))
			then return TRUE
			else return OccursIn(node, Tail(listOfPairs))
```

```
MakePairs(list,parent)
	if Null(list)
		then return()
		else return Cons(MakeList(Head(list),parent),MakePairs(Tail(list),parent))
```