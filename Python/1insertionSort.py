"""
Practical 1
Write a program to implement insertion sort and find the
the running time of the algorithm
"""

import time

def insertionSort(a):
    for i in range(1,len(a)):
        key = a[i]
        j = i
        while j>0 and a[j-1]>key:
            a[j] = a[j-1]
            j = j - 1
        a[j] = key

    
toSort = [6,3,5,7,89,2]

start = time.time()

print("Unsorted List")
print(toSort)

print("Sorted List")
insertionSort(toSort)
print(toSort)

end = time.time()
print("Running time = {}".format(end - start))

"""
Output
Unsorted List
[6, 3, 5, 7, 89, 2]
Sorted List
[2, 3, 5, 6, 7, 89]
Running time = 0.00010991096496582031
"""
