package frc.robot.aprilTagCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.commands.limelightSuckADick;
import frc.robot.commands.readAprilTags;
import frc.robot.commands.wenchControl;

public class shooterForSpeaker extends Command {
     public static double distance;

     //liemlight specific values//
     double limelightYValue;
     double limelightXValue;

     //own values//
     double specificYValue=-6;
     double specificXValue=0;
     double yOffset=1;

     public shooterForSpeaker() {
       
     }
    
     @Override
     public void initialize() {
        
     }
   
     @Override
     public void execute() {
          distance = limelightSuckADick.areaValue; // get distance
          limelightXValue = limelightSuckADick.xValue; //get x value
          limelightYValue = limelightSuckADick.yValue; //get y value

          
          //speaker.neededSpeed = ((distance/2) * 2);
     } 
    
    
}


