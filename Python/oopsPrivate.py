class Car:
    __maxspeed = 0
    __name = ''
    
    def __init__(self):
        self.__maxspeed = 200
        self.__name = "Supercar"
        
    def drive(self):
        print("maxspeed is ",self.__maxspeed)
        
    def setSpeed(self,speed):
        self.__maxspeed = speed

obj1 = Car()
obj1.drive()

obj1._maxSpeed = 300
obj1.drive()

obj1.setSpeed(300)
obj1.drive()