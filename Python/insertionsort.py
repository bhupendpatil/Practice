def insertionSort(nlist):
    for i in range(1,len(nlist)):
        current = nlist[i]
        position = i

        while position > 0 and nlist[position-1] > current:
            nlist[position] = nlist[position-1]
            position = position - 1

        nlist[position] = current

a = [17,123,1,213,1,32]
insertionSort(a)
print(a)
