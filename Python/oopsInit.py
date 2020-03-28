class Student:
    def __init__(self,name,branch,year):
        self.n = name
        self.b = branch
        self.y = year
    def print_method(self):
        print("Name: ",self.n)
        print("Branch: ",self.b)
        print("Year: ",self.y)

obj1 = Student("Bhupend","CS","2020")
obj1.print_method()