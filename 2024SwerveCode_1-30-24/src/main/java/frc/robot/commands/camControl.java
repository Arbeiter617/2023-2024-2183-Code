package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class camControl extends Command {
     public static double camAngle;
     public static double controllerAngle;
     public static double camAngleAdd;

     private double maxAngle = 180;
     private double minAngle = 0;
     public camControl() {
       
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        camAngle = Constants.camServo.getAngle();
        controllerAngle = RobotContainer.copilot.getRawAxis(3);

        //control servo//
        if(controllerAngle <= -.5) {
            //servo left//
            if(camAngleAdd > minAngle) {
                camAngleAdd = camAngleAdd - 2;
            }

        } else if(controllerAngle >= .5) {
            //servo right//
             if(camAngleAdd < maxAngle) {
                camAngleAdd = camAngleAdd + 2;
            }
            
        } else {
            //servo in the middle//
            camAngleAdd = 45;
        }

        Constants.camServo.setAngle(camAngleAdd);

        
    }
}
