package frc.robot.aprilTagCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.commands.limelightReadingTool;

public class speaker extends Command {
    //specific values on axis//
    double centerXValue = 0;
    double centerYValue = -24;
    double centerXValueFar = 0;
    double centerYValueFar = -20;
    
    //offsets//
    double yOffset = 2;
    double xOffset = 2;

    //variable speeds//
    double wenchNeededSpeed = .6;
    double rotationSpeed = .1;

    //specific distances//
    double closeDistance = 0.5;
    
    public static double neededSpeed;

     public speaker() {}
   
     @Override
     public void initialize() {}
   
     @Override
     public void execute() {

        //checking robot-to-aprilTag distances//
        neededSpeed = 1;

        Constants.shooterLeft.set(-neededSpeed);
        Constants.shooterRight.set(neededSpeed);
                
    if(limelightReadingTool.idRead != -1) {
        if(limelightReadingTool.areaValue > .14) {
            if(limelightReadingTool.yValue > (centerYValue + yOffset)) {
             Constants.wenchMotor.set(-wenchNeededSpeed);
             } else if(limelightReadingTool.yValue < (centerYValue - yOffset)) {
             Constants.wenchMotor.set(wenchNeededSpeed);
            } else {
             Constants.wenchMotor.set(0);
            }
        } else if(limelightReadingTool.areaValue <= .14){
            if(limelightReadingTool.yValue > (centerYValueFar + yOffset)) {
             Constants.wenchMotor.set(-wenchNeededSpeed);
             } else if(limelightReadingTool.yValue < (centerYValueFar - yOffset)) {
             Constants.wenchMotor.set(wenchNeededSpeed);
            } else {
             Constants.wenchMotor.set(0);
            }
        }   
    } 
 }
}

