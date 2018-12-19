"""
Practical 3
Given array of numbers of length 1. Write a program to generate a
ramdom permutation of the array using:
i) Permute-by-Sorting
"""

import random
import time

count = 0

def my_min(a):
    global count
    count += len(a)
    return a.index(min(a))

def swapp(a,b,c):
    global count
    count += 1
    a[b],a[c] = a[c],a[b]

def permute_random(a):
    n = len(a)
    random_keys = [random.randint(0,10 ** n) for i in a]
    for i in range(n):
        k = my_min(random_keys)
        swapp(a,i,k-i)
        random_keys.pop(k)
    return a;


aList = [1,2,3,4,5,6,7,8,9,10]

start = time.time()

print("UnSorted:")
print(aList)

sortedaList = permute_random(aList)

print("Sorted:")
print(sortedaList)

end = time.time()
print("Running time = {}".format(end - start))

"""
Output
UnSorted:
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Sorted:
[7, 10, 5, 9, 8, 2, 1, 6, 3, 4]
Running time = 0.0003116130828857422
"""
