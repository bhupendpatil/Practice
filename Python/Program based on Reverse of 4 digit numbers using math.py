# Program based on Reverse of 4 digit numbers

import math

n = int(input("Enter numbers: "))

a = n%10

b = math.floor(n/10)
b1 = b%10

c = math.floor(n/100)
c1 = c%10

d = math.floor(n/1000)

print(a*1000+b1*100+c1*10+d)
