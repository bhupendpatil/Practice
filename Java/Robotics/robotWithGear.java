// Write a program to create a robot
// i) Robot with gear

import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.Tools;

public class robotWithGear {
  robotWithGear() {
    LegoRobot robot=new LegoRobot();
    Gear gear=new Gear();
    robot.addPart(gear);
    
    gear.forward();
    Tools.delay(2000);
    
    gear.left(550);
    gear.forward();
    
    Tools.delay(2000);
    
    gear.left(550);
    gear.forward();
    
    Tools.delay(2000);
    
    gear.left(550);
    gear.forward();
    
    Tools.delay(2000);
    
    gear.right(550);
    gear.forward();
    
    Tools.delay(2000);
    
    robot.exit();
  }
  
  public static void main(String[] args) {
    new robotWithGear();
  }
}
