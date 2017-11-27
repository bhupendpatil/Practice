# Palindrom Number

a = int(input("Enter a Number:  "))

b = list(map(int, str(a)))

c = b[::-1]

if b==c:
    print("It is a Palindrom Number")
else:
    print("It is not a Palindrom Number")
