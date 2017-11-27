# Program to check whether a person is in profit or loss

costPrice = int(input("Cost Price of a product?   :   "))
sellingPrice = int(input("Selling Price of a product?   :   "))

jhol = costPrice - sellingPrice

if jhol > 0:
    print("Seller is in loss by Rs.{}".format(jhol))
elif jhol < 0:
    jhol = int(jhol*-1)
    print("Seller is in profit by Rs.{}".format(jhol))
else:
    print("No profit nor loss")
