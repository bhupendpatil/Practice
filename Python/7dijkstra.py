"""
Practical 7
Write a program to implement Dijkstra's Algorithm
"""

import time
import heapq as hq
inf = float('Inf')

def dijkstra(G,s):
    n = len(G)

    Q = [(0,s)]

    d = [inf for i in range(n)]
    d[s]=0

    while len(Q)!=0:
        (cost,u) = hq.heappop(Q)

        for v in range(n):
            if d[v] > d[u] + G[u][v]:
                d[v] = d[u] + G[u][v]
                hq.heappush(Q,(d[v],v))

    return d

G = [\
        [0.0,  1.0,  3.0,  inf],\
        [1.0,  0.0,  1.0,  4.0],\
        [3.0,  1.0,  0.0,  2.0],\
        [inf,  4.0,  2.0,  0.0]]

start = time.time()
d = dijkstra(G, 0)
print("Shortest path is {}".format(d))
end = time.time()
print("Running time = {}".format(end - start))

"""
Output
Shortest path is [0, 1.0, 2.0, 4.0]
Running time = 0.00011801719665527344
"""