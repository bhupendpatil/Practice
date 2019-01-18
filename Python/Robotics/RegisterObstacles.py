# Program to Regiester Obstacles

from simrobot import *

RobotContext.showNavigationBar()
RobotContext.useObstacle("sprites/bar0.gif",250,200)
RobotContext.useObstacle("sprites/bar1.gif",400,250)
RobotContext.useObstacle("sprites/bar2.gif",250,400)
RobotContext.useObstacle("sprites/bar3.gif",100,250)

robot=LegoRobot()
gear=Gear()
ts=TouchSensor(SensorPort.S3)
robot.addPart(ts)
robot.addPart(gear)

gear.setSpeed(40)
gear.forward()

while True:
    if ts.isPressed():
        gear.backward()
        gear.left(850)
        gear.forward()