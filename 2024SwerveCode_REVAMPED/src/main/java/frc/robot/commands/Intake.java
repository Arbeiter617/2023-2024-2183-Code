package frc.robot.commands;

import com.revrobotics.SparkPIDController;

import edu.wpi.first.math.trajectory.ExponentialProfile.Constraints;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class Intake extends Command {
     public static SparkPIDController intakeMotorInPID;
     public static Boolean intakeIsIn = false;

     public static boolean intakeCanComeUp = false;
    
     public Intake() {
       
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        //check for ring//
        if(colorSensorRun.pieceIsFound) {
            intakeCanComeUp = true;
        } else {
            intakeCanComeUp = false;
        }

      if(!toggleLiemlight.toggleHumanLoaderAngle && !RobotContainer.pitController.getRawButton(1)) {
        if(RobotContainer.copilot.getRawButton(3) && !toggleLiemlight.toggleLimelightPos) {
            if(RobotContainer.copilot.getRawButton(1) && !colorSensorRun.pieceIsFound) {
                //ring in//
                Constants.intakeMotorIn.set(1);
                
            } else if(RobotContainer.copilot.getRawButton(1) && colorSensorRun.pieceIsFound) {
                //ring in//
                Constants.intakeMotorIn.set(.25);
            }
        } else if(RobotContainer.copilot.getRawButton(4) && !toggleLiemlight.toggleLimelightPos) {
            if(RobotContainer.copilot.getRawButton(1)) {
                //ring out//
                Constants.intakeMotorIn.set(-1);
            } 
        }else if(toggleLiemlight.toggleLimelightPos && RobotContainer.copilot.getRawButton(4)) {
            if(RobotContainer.copilot.getRawButton(1) && readAprilTags.isAmp) {
                //ring out//
                Constants.intakeMotorIn.set(-frc.robot.aprilTagCommands.amp.outakeSpeed);
            } else if(RobotContainer.copilot.getRawButton(1) && readAprilTags.isStage){
                Constants.intakeMotorIn.set(-.8);
            } else {
                Constants.intakeMotorIn.set(-1);
            }
        } else { 
            Constants.intakeMotorIn.set(0);
        }
    }

    if(!RobotContainer.pitController.getRawButton(2)) {
        //intake up and down//
        if(RobotContainer.copilot.getRawAxis(1) < .5 && Robot.intakeUpEncoder.getPosition() > -8){
            //intake down//
            intakeIsIn = false;
            Constants.intakeMotorUp.set(-.3);
        } 
        else if(Robot.intakeUpEncoder.getPosition() <= -8 && Robot.intakeUpEncoder.getPosition() != 0){
            intakeIsIn = false; 
           if(intakeCanComeUp) {
            //come up//
             Constants.intakeMotorUp.set(.25); 
           } else {
            if(RobotContainer.copilot.getRawAxis(1) > -.5) {
                //intake manual up//
                Constants.intakeMotorUp.set(.15);
            }
           }
        } else {
            //intake stop//
            Constants.intakeMotorUp.set(0);
            intakeIsIn = true;
        }
    }
        if(RobotContainer.copilot.getRawButton(6)) {
            //reset encoder for intake//
            Robot.intakeUpEncoder.setPosition(0);
        }
    }
}
