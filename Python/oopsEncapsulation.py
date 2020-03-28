class Ecap:
    def __init__(self):
        self.a = 123
        self.__b = 123
        self.__c = 123
        
obj1 = Ecap()
print(obj1.a,obj1._Ecap__b,obj1._Ecap__c)