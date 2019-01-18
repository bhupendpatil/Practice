"""
Practical 5
Write a program to implement Huffman's code algorithm
"""

import time
import heapq
from collections import defaultdict


def encode(frequency):
    heap = [[weight, [symbol, '']] for symbol, weight in frequency.items()]
    heapq.heapify(heap)
    while len(heap) > 1:
        lo = heapq.heappop(heap)
        hi = heapq.heappop(heap)
        for pair in lo[1:]:
            pair[1] = '0' + pair[1]
        for pair in hi[1:]:
            pair[1] = '1' + pair[1]
        heapq.heappush(heap, [lo[0] + hi[0]] + lo[1:] + hi[1:])
    return sorted(heapq.heappop(heap)[1:], key=lambda p: (len(p[-1]), p))


data = input("Enter a String: ")

start = time.time()

frequency = defaultdict(int)
for symbol in data:
    frequency[symbol] += 1

huff = encode(frequency)
print("Symbol".ljust(10) + "Weight".ljust(10) + "Huffman Code")
for p in huff:
    print(p[0].ljust(10) + str(frequency[p[0]]).ljust(10) + p[1])

end = time.time()
print("Running time = {}".format(end - start))

"""
Output
Enter a String: stones from stones
Symbol    Weight    Huffman Code
s         4         10
e         2         000
n         2         010
o         3         110
t         2         011
          2         1111
f         1         0010
m         1         0011
r         1         1110
Running time = 0.0003902912139892578
"""
