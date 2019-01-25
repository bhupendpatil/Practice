a=[16,15,8,9,2,5]
print("before applying insertion sort algo",a)
for i in a:
    j=a.index(i)
    while j>0:
        if a[j-1]>a[j]:
            a[j-1],a[j]=a[j],a[j-1]

        else:
            break
        j=j-1
        print ("after applying insertion sort algo",a)
