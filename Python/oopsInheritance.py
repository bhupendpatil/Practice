#Inheritance
#Single

class fruit:
    def __init__(self):
        print("Parent class")

class citrus(fruit):
    def __init__(self):
        super().__init__()
        print("Citrus and fruit")

ob1=citrus()


#Multiple

class A:
    pass
class B:
    pass
class C(A,B):
    pass

issubclass(C,A) and issubclass(C,B)


#Multilevel

class A:
    x = 1
class B(A):
    pass
class C(B):
    pass

obj1 = C()
print(obj1.x)


#Hierarchical

class A:
    x = 1
class B(A):
    pass
class C(A):
    pass

obj1 = C()
print(obj1.x)


#Hybrid
class A:
    x = 1
class B(A):
    pass
class C(A):
    pass
class D(B,C):
    pass

obj1 = D()
print(obj1.x)