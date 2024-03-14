package frc.robot.aprilTagCommandsDriver;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.Shooter;
import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.colorSensorRun;
import frc.robot.commands.limelightSuckADick;
import frc.robot.commands.toggleLiemlight;
import frc.robot.commands.wenchControl;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.shooterPigeon;

public class stage extends Command {

    private Swerve s_Swerve;
    private shooterPigeon s_ShooterPigeon;

    Boolean wenchIsAligned;

    //editable variables//
    double neededSpeed;
    double wenchNeededSpeed;

    double neededYValueWench;
    double yOffsetWench;


     public stage() {
       this.s_Swerve = s_Swerve;
       this.s_ShooterPigeon = s_ShooterPigeon;
     }
   
     @Override
     public void initialize() {}
    
     @Override
     public void execute() {
        Shooter.shooterSpeed = neededSpeed;

        if(shooterPigeon.roll > (neededYValueWench + yOffsetWench)) {
            wenchIsAligned = false;
           Constants.wenchMotor.set(wenchNeededSpeed);
        } else if(shooterPigeon.roll < (neededYValueWench - yOffsetWench)) {
            wenchIsAligned = false;
            Constants.wenchMotor.set(-wenchNeededSpeed);
        } else {
            Constants.wenchMotor.set(0);
            wenchIsAligned = true;
        }      
    }

}
