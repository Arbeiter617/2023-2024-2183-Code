package frc.robot.autoCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.commands.limelightReadingTool;
import frc.robot.subsystems.shooterPigeon;

public class autoLimelight extends Command {
    //offsets//
    double centerYValue = -22;
    double yOffset = 2;

    //variable speeds//
    double wenchNeededSpeed = .55;

    //importing subsystems//
    private shooterPigeon s_ShooterPigeon;

     public autoLimelight() {
        this.s_ShooterPigeon = s_ShooterPigeon;
     }
   
     @Override
     public void initialize() {}
   
     @Override
     public void execute() {
        if(limelightReadingTool.idRead != -1) {
            if(limelightReadingTool.yValue > (centerYValue + yOffset)) {
                Constants.wenchMotor.set(-wenchNeededSpeed);
            } else if(limelightReadingTool.yValue < (centerYValue - yOffset)) {
                Constants.wenchMotor.set(wenchNeededSpeed);
            } else {
                Constants.wenchMotor.set(0);
            }
        } else {
                Constants.wenchMotor.set(.5);
        } 
    }
}
