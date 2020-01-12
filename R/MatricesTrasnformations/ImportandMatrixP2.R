library(igraph)
library(Matrix)

# i) View data collection
View(onemode)

#plot
netgraph = graph.data.frame(onemode, directed = T)
plot(netgraph,edge.arrow.size=.7)


# ii) Basic Networks matrices transformations

# adjacency matrix
mode1 = matrix(netgraph[],6,6)
#get.adjacency(netgraph) #optional
t(mode1))

# Sum
# to get out degree
rowSums(mode1)

# to ger in degree
colSums(mode1)


# Multiply Matrix
# for walk of distance 2 (to itself)
mode_square = mode1%*%mode1
mode_square

# for walk of distance 3 (to previous)
mode_cube = mode_square%*%mode1
mode_cube

# boolean 'AND' for distance 2
booleanAnd = mode1%&%mode1
booleanAnd