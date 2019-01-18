from simrobot import *

RobotContext.setLocation(10,10)
RobotContext.setStartDirection(4)
RobotContext.setStartPosition(100,240)
RobotContext.useObstacle("sprites/channel.gif",250,250)

robot=LegoRobot()
gear=Gear()

robot.addPart(gear)
ts1=TouchSensor(SensorPort.S1)
ts2=TouchSensor(SensorPort.S2)
robot.addPart(ts1)
robot.addPart(ts2)

gear.forward()
while True:
    t1=ts1.isPressed()
    t2=ts2.isPressed()
    
    if t1 and t2:
        gear.backward(500)
        gear.left(400)
        gear.forward()
    elif t1:
        gear.backward(500)
        gear.left(400)
        gear.forward()
    elif t2:
        gear.backward(500)
        gear.right(100)
        gear.forward()
    Tools.delay(20)