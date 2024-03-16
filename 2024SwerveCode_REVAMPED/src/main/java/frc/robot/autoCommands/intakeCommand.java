package frc.robot.autoCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class intakeCommand extends Command {

  //specific speed//
    double speed;

    //variable direction for motor//
    boolean direction;

     public intakeCommand(double speed, boolean direction) {
       this.speed = speed;
       this.direction = direction;
     }
   
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
      if(!direction) {
        //going up//
        if(Robot.intakeUpEncoder.getPosition() < 0) {
            Constants.intakeMotorUp.set(speed);
        } else {
            Constants.intakeMotorUp.set(0);
        }
      } else if(direction) {
        //going down//
        if(Robot.intakeUpEncoder.getPosition() > -8) {
            Constants.intakeMotorUp.set(-speed);
        } else {
            Constants.intakeMotorUp.set(0);
        }
      }

    }
}
