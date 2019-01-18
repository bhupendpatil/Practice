"""
Practical 9
Write a program to verify
i) Fermat's Theorem
"""
import math
import time

def fermat(a,p):
    if(a%p==0):
        print("a should not be divible by p")
    else:
        n = p - 1
        lhs = math.pow(a,n)
        llhs = lhs%p
        rhs = 1%p
        return llhs, rhs

aValue = float(input("Enter value for a: "))
pValue = float(input("Enter a prime number(p): "))

start = time.time()

lhand, rhand = fermat(aValue,pValue)
print("a^(p-1)=1(mod p) i.e {}={}".format(lhand, rhand))

end = time.time()
print("Running time = {}".format(end - start))

"""
Output
Enter value for a: 2
Enter a prime number(p): 19
a^(p-1)=1(mod p) i.e 1.0=1.0
Running time = 0.0001690387725830078
"""
