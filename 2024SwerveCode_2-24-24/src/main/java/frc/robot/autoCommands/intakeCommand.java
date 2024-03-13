package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CANdleSystem;

public class intakeCommand extends Command {
    double speed;
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
        System.out.println("help");
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
