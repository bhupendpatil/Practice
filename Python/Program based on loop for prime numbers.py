# Program based on loop for prime numbers

prime1 = int(input(("How many outputs you want:  ")))
i  = 1
while i <= prime1:
    if i%2 != 0 and i>2:
        print(i)
    i = i + 1
