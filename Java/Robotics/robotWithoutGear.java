// Write a program to create a robot
// ii) Robot without gear

import ch.aplu.robotsim.*;

public class robotWithoutGear {
  robotWithoutGear() {
    LegoRobot robot=new LegoRobot();
    Motor motA=new Motor(MotorPort.A);
    Motor motB=new Motor(MotorPort.B);
    robot.addPart(motA);
    robot.addPart(motB);
    
    motA.forward();
    motB.forward();
    Tools.delay(2000);

    motB.turn(550);
    motA.forward();
    motB.forward();
    motA.stop();     
    Tools.delay(2000);

    motB.stop();
    Tools.delay(2000);

    motB.turn(90);
    motA.forward();
    motB.forward();
    Tools.delay(2000);

    motA.backward();
    motB.backward();
    Tools.delay(2000);

    robot.exit();
  }
  
  public static void main(String[] args) {
    new robotWithoutGear();
  }
}
