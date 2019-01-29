// Change direction based on condition

import ch.aplu.robotsim.*;

public class directionCondition {
  directionCondition(){
    LegoRobot robot = new LegoRobot();
    Gear gear = new Gear();
    robot.addPart(gear);

    for (int i = 0; i< 7; i++){
      double a = Math.random();
      if (a < 0.5){
        gear.right(200);
        gear.forward();
        Tools.delay(1000);
      } else {
        gear.left(200);
        gear.forward();
        Tools.delay(1000);
      }
      gear.forward();
    }
    robot.exit();
  }
  
  public static void main(String[] args) {
    new directionCondition();
  }
}
