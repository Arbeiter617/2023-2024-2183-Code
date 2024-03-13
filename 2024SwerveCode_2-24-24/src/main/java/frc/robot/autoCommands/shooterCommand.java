package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CANdleSystem;

public class shooterCommand extends Command {
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
