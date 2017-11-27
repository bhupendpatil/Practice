# Program based on loops for table

number1 = int(input("Number: "))
a = 1

while a <= 10:
    n = a*number1
    print("{} X {} = {}".format(number1, a, n))
    a = a + 1
