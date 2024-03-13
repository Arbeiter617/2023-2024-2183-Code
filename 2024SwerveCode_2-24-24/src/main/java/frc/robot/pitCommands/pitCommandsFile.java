package frc.robot.pitCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.shooterPigeon;

public class pitCommandsFile extends Command {
    double intakeWenchSpeed = .15;
    double intakeSpeed = .5;
    double shooterspeed = .5;

    public static boolean isTesting = false;

    shooterPigeon s_shooterPigeon;
     public pitCommandsFile() {
        this.s_shooterPigeon = s_shooterPigeon;
     }
   
    
     @Override
     public void initialize() {
       
     }
   
     
     @Override
     public void execute() {

        if(RobotContainer.pitController.getRawButton(2) || RobotContainer.pitController.getRawButton(1) || RobotContainer.pitController.getRawButton(3) || RobotContainer.pitController.getRawButton(4) || RobotContainer.pitController.getRawButton(6)) {
            isTesting = true;
        } else {
            isTesting = false;
        }
        //intake wench//
        if(RobotContainer.pitController.getRawButton(2)) {
            isTesting = true;
            //run intake in certain direction//
            if(RobotContainer.pitController.getRawAxis(1) == 1) {
                 System.out.println("?");
                Constants.intakeMotorUp.set(intakeWenchSpeed);
            } else if(RobotContainer.pitController.getRawAxis(1) == -1) {
                Constants.intakeMotorUp.set(-intakeWenchSpeed);
            } else {
                //stop intake motor//
                Constants.intakeMotorUp.set(0);
               
            }
        } 

        //intake In//
        if(RobotContainer.pitController.getRawButton(1)) {
            //run intake in certain direction//
            if(RobotContainer.pitController.getRawAxis(1) == 1) {
                System.out.println("?");
                Constants.intakeMotorIn.set(-intakeSpeed);
            } else if(RobotContainer.pitController.getRawAxis(1) == -1) {
                Constants.intakeMotorIn.set(intakeSpeed);
            } else {
                //stop intake motor//
                Constants.intakeMotorIn.set(0);
            }
       
        }

        //shooter Speed//
             if(RobotContainer.pitController.getRawButton(3)) {
            //run shooter in certain direction//
            if(RobotContainer.pitController.getRawAxis(1) == 1) {
                Constants.shooterLeft.set(-shooterspeed);
                Constants.shooterRight.set(shooterspeed);
            } else if(RobotContainer.pitController.getRawAxis(1) == -1) {
                Constants.shooterLeft.set(shooterspeed);
                Constants.shooterRight.set(-shooterspeed);
            } else {
                //stop shooter motor//
                Constants.shooterLeft.set(0);
                Constants.shooterRight.set(0);
            }   
        }

        //Linear Actuator//
             if(RobotContainer.pitController.getRawButton(4)) {
            //run wench in certain direction//
            if(RobotContainer.pitController.getRawAxis(1) == 1) {
                Constants.wenchMotor.set(-.5);
            } else if(RobotContainer.pitController.getRawAxis(1) == -1) {
                Constants.wenchMotor.set(.5);
            } else {
                //stop wench motor//
                Constants.wenchMotor.set(0);
            }
        
        }

        //Climber Speeds//
             if(RobotContainer.pitController.getRawButton(6)) {
            //run climber in certain direction//
            if(RobotContainer.pitController.getRawAxis(1) == 1) {
                Constants.climberLeft.set(.5);
            } else if(RobotContainer.pitController.getRawAxis(1) == -1) {
                Constants.climberLeft.set(-.5);
            } else {
                //stop climber motor//
                Constants.climberLeft.set(0);
            }

            if(RobotContainer.pitController.getRawAxis(0) == 1) {
                Constants.climberRight.set(.5);
            } else if(RobotContainer.pitController.getRawAxis(0) == -1) {
                Constants.climberRight.set(-.5);
            } else {
                //stop climber motor//
                Constants.climberRight.set(0);
            }
        
        }

    }

}

