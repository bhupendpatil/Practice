# Program to create a robot with light sensors to follow a line

from simrobot import *

RobotContext.setStartDirection(-90)
RobotContext.useBackground("sprites/border.gif")
RobotContext.setStartPosition(250, 490)

robot=LegoRobot()
ls=LightSensor(SensorPort.S3)
robot.addPart(ls)
gear=Gear()
robot.addPart(gear)

while True:
    if ls.getValue()<500:
        gear.leftArc(0.2)
    else:
        gear.rightArc(0.2)