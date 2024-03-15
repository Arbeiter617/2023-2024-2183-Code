package frc.robot.aprilTagCommandsDriver;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.commands.colorSensorRun;
import frc.robot.commands.toggleLiemlight;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.shooterPigeon;

public class stage extends Command {
  //importing subsystems//
    private Swerve s_Swerve;
    private shooterPigeon s_ShooterPigeon;

    //booleans//
    Boolean wenchIsAligned;

    //variable speeds//
    double neededSpeed;
    double wenchNeededSpeed;

    //offsets//
    double yOffsetWench = 2;


     public stage() {
       this.s_Swerve = s_Swerve;
       this.s_ShooterPigeon = s_ShooterPigeon;
     }
   
     @Override
     public void initialize() {}
    
     @Override
     public void execute() {
        if(shooterPigeon.roll > 55.5 + yOffsetWench) {
            Constants.wenchMotor.set(.75);
        } else if(shooterPigeon.roll < 55.5 - yOffsetWench) {
          Constants.wenchMotor.set(-.75);
        }else {
          Constants.wenchMotor.set(0);
        }

        if(!colorSensorRun.pieceIsFound) {
            Constants.shooterLeft.set(.25);
            Constants.shooterRight.set(-.25);
              Constants.intakeMotorIn.set(.5);
            } else {
              Constants.intakeMotorIn.set(0);
              Constants.shooterRight.set(0);
            Constants.shooterLeft.set(0);
              toggleLiemlight.toggleHumanLoaderAngle = false;
            }
    }

}
