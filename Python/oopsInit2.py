class Vehicles:
    def __init__(self,name,color,category,worth):
        self.n = name
        self.c = color
        self.ct = category
        self.w = worth
    def description(self):
        print("Name: ",self.n)
        print("Color: ",self.c)
        print("Category: ",self.ct)
        print("Worth: $",self.w)

car1 = Vehicles("Fer","red","Convertible","70,000.00")
car2 = Vehicles("Jump","blue","van","15,000.00")

car1.description()
car2.description()