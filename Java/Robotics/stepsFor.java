// Doing steps with for loop

import ch.aplu.robotsim.*;

public class stepsFor {
  stepsFor(){
    LegoRobot robot=new LegoRobot();
    Gear gear=new Gear();
    robot.addPart(gear);
    
    for(int i=0; i<2; i++){
      gear.right(550);
      gear.forward();
      Tools.delay(2000);
      gear.left(550);
      gear.forward();
      Tools.delay(2000);
    }
  }
  
  public static void main(String[] args){
    new stepsFor();
  }
}
