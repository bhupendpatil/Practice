row = int(input("How many rows you want? "))
column = int(input("How many columns you want? "))

if row==column:
    for i in range(1,row+1):
        for j in range(1,row+1):
            if i==j:
                print("1", end = " ")
            else:
                print("0", end= " ")
        print("")
else:
    print("It does not forms square matrix")
