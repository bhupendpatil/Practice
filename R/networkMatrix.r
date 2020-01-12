library(igraph)
library(igraphdata)

#lists data
data(package = "igraphdata")


#matrix
data(kite)
plot(kite)
kite[]

#edgelist
data(Koenigsberg)
plot(Koenigsberg)
get.edgelist(Koenigsberg)

#sociogram
data(karate)
plot(karate)