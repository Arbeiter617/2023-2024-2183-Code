package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class toggleLiemlight extends Command {

    public static Boolean toggleLimelightPos = false;
    Boolean togglePos = true;

    public static Boolean toggleAutoClimb = false;
    Boolean toggle = true;

    public static Boolean toggleDriverLimelightPos = false;
    Boolean toggleDriverPos = true;

     public toggleLiemlight() {
        
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
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

           //////

            if (toggle && RobotContainer.copilot.getRawButton(12)) { 
            toggle = false;  
              if (toggleAutoClimb) { 
               toggleAutoClimb = false;
               
            } else {
              toggleAutoClimb = true;
             
            }
            } else if(RobotContainer.copilot.getRawButton(12) == false) { 
               toggle = true; 
           }

           ///////

           if (toggleDriverPos && RobotContainer.driver.getRawButton(2)) { 
            toggleDriverPos = false;  
              if (toggleDriverLimelightPos) { 
               toggleDriverLimelightPos = false;
               
            } else {
              toggleDriverLimelightPos = true;
             
            }
            } else if(RobotContainer.driver.getRawButton(2) == false) { 
               toggleDriverPos = true; 
           }

        
        SmartDashboard.putBoolean("Toggle Limelight Pos?", toggleLimelightPos);
        SmartDashboard.putBoolean("Toggle Limelight Driver Pos?", toggleDriverLimelightPos);

          NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
        
        
        
        
    }
}
