# Do a square using while loop

from simrobot import *

robot = LegoRobot()
gear = Gear()
robot.addPart(gear)

i = 0
while(i<4):
    gear.forward()
    Tools.delay(2000)
    gear.left(550)
    i+=1

robot.exit()