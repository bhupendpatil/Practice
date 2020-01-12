library(igraph)
library(igraphdata)

dir = graph(edges = c(1,2,3,4,2,3,1,3,4,2,4,5,2,5,6,2,2,7),n = 7,directed = T)
undir = graph(edges = c(1,2,3,5,2,3,2,4,5,6,3,2,5,4,3,4,5,8,6,4,4,2,4,6,4,2,1,7,4,2),n=8,directed = F)

plot(dir)
plot(undir)

# i) number of edges
gsize(undir)
ecount(undir)

# ii) number of nodes
vcount(dir)

# iii) degree of nodes
degree(dir)
centr_degree(dir) #centrrality

# iv) node with lowest degree
min(degree(dir))

# v) adjacency list
get.adjlist(dir)

# vi) matrix of graph
get.adjacency(undir)