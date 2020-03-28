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
    def desc(self):
        return ("{} is {} {} worth {}".format(self.n,self.c,self.ct,self.w))

car1 = Vehicles("Fer","red","convertible","70,000.00")
car2 = Vehicles("Jump","blue","van","15,000.00")

car1.description()
car2.description()

car1.desc()
car2.desc()