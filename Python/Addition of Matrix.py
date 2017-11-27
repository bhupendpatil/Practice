from operator import add

row = int(input("How many rows you want?  "))
column = int(input("How many column you want?  "))

a = [[] for q in range(row)]

for i in range(0,row):
    for j in range(0,column):
        y = int(input("Enter Value for A{}{}: ".format(i+1,j+1)))
        a[i].append(y)


b = [[] for q in range(row)]

for i in range(0,row):
    for j in range(0,column):
        y = int(input("Enter Value for B{}{}: ".format(i+1,j+1)))
        b[i].append(y)


print(map(add, a, b))


