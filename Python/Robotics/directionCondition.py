# Change direction based on condition

from simrobot import *
import random

robot = LegoRobot()
gear = Gear()
robot.addPart(gear)

for i in range(0,7):
    a = random.random()
    
    if a < 0.5:
        gear.right(200);
        gear.forward();
        Tools.delay(1000);
    else:
        gear.left(200);
        gear.forward();
        Tools.delay(1000);

    gear.forward();

robot.exit()
