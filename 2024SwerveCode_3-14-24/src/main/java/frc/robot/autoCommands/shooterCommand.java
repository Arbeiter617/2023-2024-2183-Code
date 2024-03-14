package frc.robot.autoCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class shooterCommand extends Command {
  //specific speed//
    double speed;

     public shooterCommand(double speed) {
       this.speed = speed;
     }
   
     @Override
     public void initialize() {}
   
     @Override
     public void execute() {
      Constants.shooterLeft.set(-speed);
      Constants.shooterRight.set(speed);

    }
}
