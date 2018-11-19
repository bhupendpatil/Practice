"""
Practical 2
Write a program to implement merge sort algorithm.
Compare the time and memory complexity.
"""

import time

def mergeSort(a):
	if len(a)>1:
		mid = len(a)//2
		left = a[:mid]
		right = a[mid:]

		mergeSort(left)
		mergeSort(right)

		i = 0
		j = 0
		k = 0
		while i<len(left) and j<len(right):
			if left[i] < right[i]:
				a[k] = left[i]
				i += 1
			else:
				a[k] = right[j]
				j += 1
			k += 1

		while i < len(left):
			a[k]=left[i]
			i += 1
			k += 1

		while j < len(right):
			a[k]=right[j]
			j += 1
			k += 1


toSort = [10,5,88,5,3]

start = time.time()

print("Unsorted:")
print(toSort)

print("Sorted:")
mergeSort(toSort)
print(toSort)

end = time.time()
print("Running time = {}".format(end - start))

"""
Output
Unsorted:
[10, 5, 88, 5, 3]
Sorted:
[3, 5, 88, 5, 10]
Running time = 0.00012421607971191406
"""