package frc.robot.autoCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.Shooter;
import frc.robot.commands.limelightSuckADick;
import frc.robot.subsystems.shooterPigeon;

public class autoLimelight extends Command {
    double centerYValue = -22;
    //wench values//
    double yOffset = 2;
    double wenchNeededSpeed = .55;
    private shooterPigeon s_ShooterPigeon;
     public autoLimelight() {
        this.s_ShooterPigeon = s_ShooterPigeon;
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        if(limelightSuckADick.idRead != -1) {
            if(limelightSuckADick.yValue > (centerYValue + yOffset)) {
                Constants.wenchMotor.set(-wenchNeededSpeed);
            } else if(limelightSuckADick.yValue < (centerYValue - yOffset)) {
                Constants.wenchMotor.set(wenchNeededSpeed);
            } else {
 
                Constants.wenchMotor.set(0);
            }
    
    
        } else {
                Constants.wenchMotor.set(.5);
            
        } 
    }
}
