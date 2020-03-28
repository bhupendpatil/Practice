class ClassName:
    var = "class variable"
    def func(self):
        print("I'm inside the Class")

obj1 = ClassName()
obj1.var

obj1.func()

obj2 = ClassName()
obj2.var = "Updated Variable"

print(obj2.var)