# Overloading

def add(instanceOf, *args):
    if(instanceOf=='int'):
        result = 0
    if(instanceOf=='str'):
        result = ''
    if(instanceOf=='float'):
        result = 0.0
    for i in args:
        result+=i
    return result

add('int',1,2,3,4,5)
add('float',1.0,3.6,4.90)
add('str','python','2323',' tuoiwjdow')


# Overriding

class A:
    def checkIt(self):
        print("A")
class B(A):
    def checkIt(self):
        print("B")
        
obj1 = A()
obj2 = B()

obj1.checkIt()
obj2.checkIt()
