"""
Practical 3
Given array of numbers of length 1. Write a program to generate a
ramdom permutation of the array using:
i) Permute-by-Sorting
"""

import random
import time

def prioritizeAndSort(a):
	size = len(a)
	priorities = random.sample(range(size*size*size),size)

	for i in range(1,size):
		key = priorities[i]
		value = a[i]
		j = i - 1

		while (j>=0 and priorities[j]>key):
			priorities[j+1]=priorities[j]
			a[j+1]=a[j];
			j = j - 1

		priorities[j+1]=key
		a[j+1]=value

	return priorities, a


aList = [1,2,3,4,5,6,7,8,9,10]

start = time.time()

print("UnSorted:")
print(aList)

prio,sortedaList = prioritizeAndSort(aList)

print("Priorities are:")
print(prio)

print("Sorted:")
print(sortedaList)

end = time.time()
print("Running time = {}".format(end - start))

"""
Output
UnSorted:
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Priorities are:
[120, 187, 340, 458, 514, 523, 550, 658, 678, 902]
Sorted:
[3, 4, 10, 7, 6, 2, 5, 9, 8, 1]
Running time = 0.0002758502960205078
"""