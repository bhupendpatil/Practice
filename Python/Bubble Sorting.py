#Bubble Sorting
#Functions
#Printing
def printing(x=[]):
    for j in x:
        print(j, end=" ")

#Sorting
def sorting(x=[]):
    for k in range(1,len(x)):
        for i in rang(0,(len(x))-k):
            if x[i]>x[i+1]:
                t = x[i+1]
                x[i+1] = x[i]
                x[i] = t
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
