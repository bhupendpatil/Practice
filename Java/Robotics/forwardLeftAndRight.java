import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.Motor;
import ch.aplu.robotsim.MotorPort;
import ch.aplu.robotsim.Tools;

public class forwardLeftAndRight {
  forwardLeftAndRight() {
    LegoRobot robot = new LegoRobot();

    Motor motA = new Motor(MotorPort.A); 
    Motor motB = new Motor(MotorPort.B);
    robot.addPart(motA);
    robot.addPart(motB);

    // Forward
    motA.forward();
    motB.forward();
    Tools.delay(2000);

    // Left
    motB.stop();
    Tools.delay(1050);
    motA.stop();
    Tools.delay(2000);

    motA.forward();
    motB.forward();
    Tools.delay(2000);

    // Right
    motA.stop();
    Tools.delay(1050);
    motB.stop();
    Tools.delay(2000);

    motA.forward();
    motB.forward();
    Tools.delay(2000);

    robot.exit();
  }

  public static void main(String[] args) {
    new forwardLeftAndRight();
  }
}
