"""
Practical 4
Write a program to implement Longest Common Subsequence
(LCS) algorithm
"""
import time

def lcs(s1,s2):
	l1 = len(s1)
	l2 = len(s2)

	arr = [[0 for x in range(l2+1)] for x in range(l1+1)]

	for i in range(l1+1):
		for j in range(l2+1):
			if i==0 or j==0:
				arr[i][j] = 0
			elif s1[i-1] == s2[j-1]:
				arr[i][j] = arr[i-1][j-1]+1
			else:
				arr[i][j] = max(arr[i-1][j],arr[i][j-1])

	index = arr[l1][l2]

	lcs = [""] * (index+1)
	lcs[index] = ""

	i = l1
	j = l2
	while i > 0 and j > 0:
		if s1[i-1] == s2[j-1]:
			lcs[index-1] = s1[i-1]
			i-=1
			j-=1
			index-=1

		elif arr[i-1][j] > arr[i][j-1]:
			i -= 1
		else:
			j -= 1

	return "".join(lcs)


a = input("Enter String 1: ")
b = input("Enter String 2: ")

start = time.time()

e = lcs(a,b)

print("Longest Common Subsequence : {}".format(e))

end = time.time()
print("Running time = {}".format(end - start))

"""
Output
Enter String 1: new york
Enter String 2: new york city
Longest Common Subsequence : new york
Running time = 0.0003960132598876953
"""