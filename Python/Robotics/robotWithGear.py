# Write a program to create a robot
# i) Robot with gear

from simrobot import *

robot = LegoRobot()
gear = Gear()
robot.addPart(gear)

Tools.delay(2000)

gear.left(550)
gear.forward()

Tools.delay(2000)

gear.left(550)
gear.forward()

Tools.delay(2000)

gear.left(550)
gear.forward()

Tools.delay(2000)

gear.right(550)
gear.forward()

Tools.delay(2000)

robot.exit()