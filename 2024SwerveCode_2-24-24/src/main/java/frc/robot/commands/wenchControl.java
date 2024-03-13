package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.shooterPigeon;



public class wenchControl extends Command {
    public int povNumbers;
    public static double wenchPID;
    shooterPigeon s_shooterPigeon;
    private shooterPigeon s_ShooterPigeon;

    public static Boolean manualMoveing = false;
     public wenchControl() {
        this.s_shooterPigeon = s_shooterPigeon;
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        povNumbers = RobotContainer.copilot.getPOV();


    if(!toggleLiemlight.toggleLimelightPos && !toggleLiemlight.toggleAutoClimb && !toggleLiemlight.toggleHumanLoaderAngle && !RobotContainer.pitController.getRawButton(4)) {
        if(povNumbers == 0 && shooterPigeon.roll < 52) {
            //wench up//
            Constants.wenchMotor.set(-1);
            manualMoveing = true;
        } else if(povNumbers == 180) {
            //wench down//
            Constants.wenchMotor.set(1);
            manualMoveing = true;
        } else {
            //wench stop//
            Constants.wenchMotor.set(0);
            manualMoveing = false;
        }

    }

        
    }
}
