library(igraph)
library(multigraph)

affiliation_matrix=matrix(c(
  1,1,0,1,
  1,0,1,0,
  1,1,1,1,
  0,0,1,1,
  0,1,1,1
),
nrow = 5,
ncol = 4,
byrow = TRUE)
dimnames(affiliation_matrix)=list(
  c("utej","danish","pravin","shubham","bhupend"),
  c("staurtlittle","harrypotter","interstellar","titanic"))

affiliation_matrix

two_mode_network=graph.incidence(affiliation_matrix)
two_mode_network

plot(two_mode_network, vertex.color=V(two_mode_network)$type)

bmgraph(affiliation_matrix,pch = 16:15)

one_mode_networks=bipartite.projection(two_mode_network)
one_mode_networks

get.adjacency(one_mode_networks$proj1,sparse = FALSE, attr = "weight")
get.adjacency(one_mode_networks$proj2,sparse = FALSE, attr = "weight")

plot(one_mode_networks$proj1,edge.label=E(one_mode_networks$proj1)$weight,edge.width=E(one_mode_networks$proj1)$weight)
plot(one_mode_networks$proj2,edge.label=E(one_mode_networks$proj2)$weight,edge.width=E(one_mode_networks$proj2)$weight)
