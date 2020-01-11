library(igraph)
library(igraphdata)

dir = graph(edges = c(1,2,2,3,3,1), n = 3,directed = T)
undir = graph(edges = c(1,2,2,3,3,4,4,1), n = 4,directed = F)

plot(dir)

#names of vertices
V(dir)

#edges names
E(dir)

#number of edges
ecount(undir)

#number of vertices
vcount(dir)

#names of neighbor node directed edges
neighbors(dir,2)

#number of degree of node
degree(dir)

#minimum no. of degree
min(degree(dir))

#names of min no.of degree in graph
V(dir)[degree(dir)==min(degree(dir))]

#get adjacent list
get.adjlist(dir)

#get edge list
get.adjedgelist(dir)

#get adjacency matrix
get.adjacency(dir)