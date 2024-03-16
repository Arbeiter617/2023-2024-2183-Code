package frc.robot.autoCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.commands.colorSensorRun;

public class colorSensorIntake extends Command {
    //specifc speed//
    double speed;

     public colorSensorIntake(double speed) {
       this.speed = speed;;
     }
   
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        if(!colorSensorRun.pieceIsFound) {
          Constants.intakeMotorIn.set(-speed);
        } else {
          Constants.intakeMotorIn.set(0);
        }
    }
}
