#search result

a = int(input("Enter length of the list: "))

b = []

h = []

for i in range(1,1+a):
    c = int(input("Enter number {}: ".format(i)))
    b.append(c)

d = int(input("Number you would like to search: "))

for q in b:
    if q==d:
        h.append(q)    

if h:
    e = b.index(d)+1
    print("Number {} is on position '{}'".format(d, e))
else:
    print("Number {} not found.".format(d))
