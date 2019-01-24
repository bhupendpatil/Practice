// Program to create a robot with light sensors to follow a line

import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.LightSensor;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;

public class lightSensor{
  lightSensor(){
    LegoRobot robot = new LegoRobot();
    LightSensor ls = new LightSensor(SensorPort.S3);
    robot.addPart(ls);
    
    Gear gear = new Gear();
    
    robot.addPart(gear);
    
    while(true){
      if(ls.getValue()< 500)
        gear.leftArc(0.1);
      else
        gear.rightArc(0.1);
    }
  }
  
  static{
    RobotContext.setStartDirection(-90);
    RobotContext.setStartPosition(250, 490);
    RobotContext.useBackground("sprites/border.gif");
  }
  
  public static void main(String[] args){
    new lightSensor();
  }
}
