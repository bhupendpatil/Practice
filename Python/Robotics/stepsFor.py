# Doing steps with for loop

from simrobot import *

robot = LegoRobot()
gear = Gear()
robot.addPart(gear)

for i in range(0,2):
    gear.right(550)
    gear.forward()
    Tools.delay(2000)
    gear.left(550)
    gear.forward()
    Tools.delay(2000)

robot.exit()