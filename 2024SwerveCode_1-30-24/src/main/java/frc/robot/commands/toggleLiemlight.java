package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class toggleLiemlight extends Command {
    static Boolean toggleLimelight = false;
    Boolean toggle = true;

    static Boolean toggleLimelightPos = false;
    Boolean togglePos = true;
     public toggleLiemlight() {
        
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        if (toggle && RobotContainer.copilot.getRawButton(5)) { 
            toggle = false;  
              if (toggleLimelight) { 
               toggleLimelight = false;
               
            } else {
              toggleLimelight = true;
             
            }
            } else if(RobotContainer.copilot.getRawButton(5) == false) { 
               toggle = true; 
           }
///////
            if (togglePos && RobotContainer.copilot.getRawButton(11)) { 
            togglePos = false;  
              if (toggleLimelightPos) { 
               toggleLimelightPos = false;
               
            } else {
              toggleLimelightPos = true;
             
            }
            } else if(RobotContainer.copilot.getRawButton(11) == false) { 
               togglePos = true; 
           }

        
        SmartDashboard.putBoolean("Toggle Limelight Shooter?", toggleLimelight);
        SmartDashboard.putBoolean("Toggle Limelight Pos?", toggleLimelightPos);

        if(toggleLimelight || toggleLimelightPos) {
          NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
        } else {
          NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
        }
        
    }
}
