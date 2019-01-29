// Do a square using while loop

import ch.aplu.robotsim.*;

public class doSquareWhile {
  doSquareWhile(){
    LegoRobot robot=new LegoRobot();
    Gear gear=new Gear();
    robot.addPart(gear);
    
    int i=0;
    while(i<4){
      gear.forward();
      Tools.delay(2000);
      gear.left(550);
      i++;
    }
    
    robot.exit();
  }
  public static void main(String[] args){
    new doSquareWhile();
  }
}
