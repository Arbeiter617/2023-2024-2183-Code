package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Shooter extends Command {
     public static double shooterSpeed;
      
     Boolean toggle = true;
    public static Boolean fireToggle = false;
     public Shooter() {
     }
   
     @Override
     public void initialize() {}
   
     @Override
     public void execute() {
    if(!toggleLiemlight.toggleLimelightPos && !toggleLiemlight.toggleHumanLoaderAngle && !RobotContainer.pitController.getRawButton(3)) {
      if(RobotContainer.copilot.getRawAxis(2) < 0) {
        shooterSpeed = (RobotContainer.copilot.getRawAxis(2) * -1);

      } else if(RobotContainer.copilot.getRawAxis(2) > 0) {
        shooterSpeed = -.25;
      } else {
          shooterSpeed = 0;
        
      }
    } 

      if(RobotContainer.copilot.getRawButton(1)) {
        if (toggle && RobotContainer.copilot.getRawButton(2)) { 
        toggle = false;  
          if (fireToggle) { 
           fireToggle = false;
           
        } else {
          fireToggle = true;
         
        }
        } else if(RobotContainer.copilot.getRawButton(2) == false) { 
           toggle = true; 
       }
      } else {
        fireToggle = false;
      }
      
       //can i fire?//
        if(fireToggle) {
        Constants.shooterLeft.set(-shooterSpeed);
          Constants.shooterRight.set(shooterSpeed);
       } else {
        if(!toggleLiemlight.toggleLimelightPos && !toggleLiemlight.toggleHumanLoaderAngle && !RobotContainer.pitController.getRawButton(3)) {
          Constants.shooterLeft.set(0);
          Constants.shooterRight.set(0);
        }
       }

       SmartDashboard.putBoolean("Toggle Fire?", fireToggle);

    }
}
