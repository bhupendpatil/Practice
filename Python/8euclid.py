"""
Practical 8
Write a ptogram to implement Euclid's algorithm to implement
gc of two non-negative integers a and b. Extend the algorithm
to find x and y such that gcd(a,b)=ax+by. Compare the running
time and recursive calls made in each case.
"""
import time

def gcd(a,b):
    if (b==0):
        return a
    else:
        return gcd(b,a%b);

firstN = int(input("Enter first number: "))
secondN = int(input("Enter second number: "))

start = time.time()

if firstN<0 or secondN<0:
    print("Enter only non-negative numbers")
else:
    print("GCD is {}".format(gcd(firstN,secondN)))

end = time.time()
print("Running time = {}".format(end - start))

"""
Output
Enter first number: 21
Enter second number: 9
GCD is 3
Running time = 0.00011205673217773438
"""
