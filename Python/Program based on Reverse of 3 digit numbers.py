# Program based on Reverse of 3 digit numbers

a = int(input("Enter 3 digit number:  "))
b = a%10
c = int(a/10)
d = c%10
e = int(a/100)
number = (b*100+d*10+e)
print(number)
