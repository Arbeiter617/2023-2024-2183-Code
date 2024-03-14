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

          if(!wenchControl.manualMoveing) {

          
                if(specificYValue > (limelightYValue + yOffset)) {
                 Constants.wenchMotor.set(.15);
               } else if(specificYValue < (limelightYValue + yOffset)) {
                Constants.wenchMotor.set(-.15);
               } else {
                Constants.wenchMotor.set(-.15);
          }
     }

       
    }
    
    }


