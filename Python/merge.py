def mergeSort(alist):
    c=0
    
    if len(alist)>1:
        mid=len (alist)//2
        l=alist[:mid]
        r=alist[mid:]
          
        mergeSort(l)
        mergeSort(r)


        i=0
        j=0
        k=0
        while i<len(l) and j<len(r):
            c=c+1
            if l[i]<r[j]:
                alist[k]=l[i]
                i=i+1
            else:
                alist[k]=r[j]
                j=j+1
            
            k=k+1

        while i<len(l):
            c=c+1
            alist[k]=l[i]
            i=i+1
            k=k+1

        while j<len(r):
            c=c+1
            alist[k]=r[j]
            j=j+1
            k=k+1

    print("merging",alist)
    return c

alist=[54,23,50,36,14,78,98]
print("list for sorting")
print("\t",alist)
print("applying merge sort:\n")
c=mergeSort(alist)
print("after sorting ",alist)
print("runtime=",c)
