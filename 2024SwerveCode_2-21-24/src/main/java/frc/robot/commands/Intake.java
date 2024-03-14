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

     public Intake() {
       
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        intakeMotorInPID = Constants.intakeMotorUp.getPIDController();
        //set the ranges//
        intakeMotorInPID.setOutputRange(0, 30);
        intakeMotorInPID.setSmartMotionMaxAccel(10, 0);
        intakeMotorInPID.setSmartMotionMaxVelocity(15, 0);

        //set error//
        intakeMotorInPID.setSmartMotionAllowedClosedLoopError(1,0);
        intakeMotorInPID.setFF(.06);

        if(RobotContainer.copilot.getRawButton(3)) {
            if(RobotContainer.copilot.getRawButton(1)) {
                //ring in//
                Constants.intakeMotorIn.set(.8);
                
            } 
        } else if(RobotContainer.copilot.getRawButton(4)) {
            if(RobotContainer.copilot.getRawButton(1)) {
                //ring out//
                Constants.intakeMotorIn.set(-1);
            } 
        } else {
            
                Constants.intakeMotorIn.set(0);
            
            
        }

        //intake up and down//
        if(RobotContainer.copilot.getRawAxis(1) >= .5 && Robot.intakeUpEncoder.getPosition() > 0){
            //intake up//
            //Constants.intakeMotorUp.set(-.15);

            if(Robot.intakeUpEncoder.getPosition() <= 2.5) {
            Constants.intakeMotorUp.set(-.01);
           } else {
            Constants.intakeMotorUp.set(-.3);
           }
        } 
        else if(RobotContainer.copilot.getRawAxis(1) <= -.5 && Robot.intakeUpEncoder.getPosition() < 7){
            Constants.intakeMotorUp.set(.15);
           
            
        } else {
           if(Robot.intakeUpEncoder.getPosition() > 6.5) {
                Constants.intakeMotorUp.set(-.05);
            } else {
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
