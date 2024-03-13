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

    public static Boolean toggleHumanLoaderAngle = false;
    Boolean toggleAngle = true;

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
              // readAprilTags.isAmp = false;
              // readAprilTags.isSpeaker = false;
              // readAprilTags.isStage = false;

              //toggle checker once//
              RobotContainer.checkingArray.initialize();

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

           if (toggleAngle && RobotContainer.copilot.getRawButton(5)) { 
            toggleAngle = false;  
              if (toggleHumanLoaderAngle) { 
               toggleHumanLoaderAngle = false;
               
            } else {
              toggleHumanLoaderAngle = true;
             
            }
            } else if(RobotContainer.copilot.getRawButton(5) == false) { 
               toggleAngle = true; 
           }

           //human loader thingy//
           if(toggleHumanLoaderAngle) {
            RobotContainer.driverStage.execute();
           }

        
        SmartDashboard.putBoolean("Toggle Limelight Pos?", toggleLimelightPos);
        SmartDashboard.putBoolean("Human Loader Angle?", toggleHumanLoaderAngle);

      
        
        
        
        
    }
}
