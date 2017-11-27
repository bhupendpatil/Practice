#Efficient Sorting
#Functions
#Printing
def printing(x=[]):
    for j in x:
        print(j, end=" ")

#Sorting
def sorting(x=[]):
    for k in range(0,len(x)):
        small = k
        for i in rang(k,len(x)):
            if x[small]>x[i]:
                small = i
            t = x[k]
            x[k] = x[small]
            x[small] = t
    return x

#Script
#Get length from User
a = int(input("Length of list: "))

#Initialization of list
b = [0 for _ in range(a)]

#Storing values in b
for s in range(0,a):
    b[s] = int(input("Enter {} value:  ".format(s+1)))

#Print your list:
print("\nYour list: ")
printing(b)

#Print sorted list:
print("\nYour Sorted List:")
c = sorted(b)
printing(c)
