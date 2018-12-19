"""
Practical 3
Given array of numbers of length 1. Write a program to generate a
ramdom permutation of the array using:
ii) Permute-by-Cyclic
"""

import time
import random

def cyclic(a):
    size = len(a)
    ssorted = list(range(size))

    offset = random.randint(0,size)

    for i in range(0,size):
        dest = i + offset;
        if(dest>=size):
            dest=dest-size;
        ssorted[dest]=a[i]
        
    return ssorted;

ab = [1,2,3,4,5,6,7,8,9,10]

start = time.time()

print("Orginal Array")
print(ab)

print("After permutation")
print(cyclic(ab))

end = time.time()
print("Running time = {}".format(end - start))

"""
Output
Orginal Array
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
After permutation
[5, 6, 7, 8, 9, 10, 1, 2, 3, 4]
Running time = 0.0001239776611328125
"""
