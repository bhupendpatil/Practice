# Control speed using switch case

from simrobot import *

robot = LegoRobot()
gear = Gear()
robot.addPart(gear)

def speeds(i):
    switcher = {
        1 : 10,
        2 : 50,
        3 : 100,
        4 : 150,
        5 : 60
    }
    return switcher.get(i)

for i in range(1,6):
    speed = speeds(i)
    
    gear.setSpeed(speed)
    gear.forward()
    Tools.delay(2000)
    gear.right(500)

robot.exit()