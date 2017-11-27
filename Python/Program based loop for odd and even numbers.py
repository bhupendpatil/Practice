# Program based loop for odd and even numbers

o = int(input("How many outputs you want:  "))
i = 1

while i <= o:
    if (i%2):
        print("{} is odd".format(i))
    else:
        print("{} is even".format(i))
    i = i + 1
