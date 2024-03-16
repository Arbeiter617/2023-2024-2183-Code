package frc.robot.autoCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.commands.colorSensorRun;

public class intakeMotorCommand extends Command {

  //specific speed//
    double speed;

    //variable direction for motors//
    boolean direction;

     public intakeMotorCommand(double speed, boolean direction) {
       this.speed = speed;
       this.direction = direction;
     }
   
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
      
      if(direction) {
        if(!colorSensorRun.pieceIsFound) {
          Constants.intakeMotorIn.set(speed);
        } else {
          Constants.intakeMotorIn.set(0);
        }
      } else if(!direction) {
        Constants.intakeMotorIn.set(-speed);
      }
    }
}
