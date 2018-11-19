"""
Practical 9
Write a program to verify
ii) Eulers's Theorem
"""

import math
import time
import decimal

def gcd(a,b):
	if(b==0):
		return a
	else:
		return gcd(b,a%b)

def phi(n):
	count = 0
	for i in range(0,n):
		if(gcd(i,n)==1):
			count = count + 1
	return count

def euler(a,n,p):
	lhs = float(math.pow(a,p))
	rhs = float(lhs%n)
	return lhs,rhs

aValue = int(input("Enter value for a: "))
bValue = int(input("Enter value for n: "))

start = time.time()

phi = phi(bValue)


e,f = euler(aValue,bValue,phi)
de = '%.2E'% decimal.Decimal(e)
print("a^phi(n)=1(mod n) i.e {} = {}".format(de,f))

end = time.time()
print("Running time = {}".format(end - start))

"""
Output
Enter value for a: 10
Enter value for n: 11
a^phi(n)=1(mod n) i.e 1.00E+10 = 1.0
Running time = 0.000361204147339
"""