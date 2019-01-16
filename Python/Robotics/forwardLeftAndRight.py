# Write a program to create a robot with 2 motor and move it forward, left & right

from simrobot import *

robot = LegoRobot()

motA = Motor(MotorPort.A)
motB = Motor(MotorPort.B)
robot.addPart(motA)
robot.addPart(motB)

# Forward
motA.forward()
motB.forward()
Tools.delay(2000)

# Left
motB.stop()
Tools.delay(1050)
motA.stop()
Tools.delay(2000)

motA.forward()
motB.forward()
Tools.delay(2000)

# Right
motA.stop()
Tools.delay(1050)
motB.stop()
Tools.delay(2000)

motA.forward()
motB.forward()
Tools.delay(2000)

robot.exit()