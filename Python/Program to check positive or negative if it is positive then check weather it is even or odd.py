#Program to check positive or negative if it is positive then check whether if it is even or odd

a = int(input("Enter Number:  "))

if a > 0:
    if a%2:
        print("Number is odd Positive")
    else:
        print("Number is even Positive")
elif a < 0:
    print("Number is negative")
else:
    print("Zero")
