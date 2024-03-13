package frc.robot.aprilTagCommands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.Shooter;
import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.limelightSuckADick;
import frc.robot.commands.readAprilTags;
import frc.robot.commands.toggleLiemlight;
import frc.robot.commands.wenchControl;
import frc.robot.subsystems.shooterPigeon;

public class amp extends Command {
    Translation2d newTranslation;
    shooterPigeon s_shooterPigeon;
    //private frc.robot.subsystems.Swerve s_Swerve = TeleopSwerve.s_Swerve;

    //58 deg//

    //specific values//
    double translationSupLocal;
    double rotationSupLocal;
    double strafeSupLocal;
    boolean robotCentricSupLocal = true;

    double neededSpeed = .21;
    double neededAngle = 55;

    private double yOffset = 2;
    double neededYValue = 10;

    private double xOffset = 2;
    double neededXValue = 0;

    double alignSpeed = .1;

    double wenchNeededSpeed = .35;
    boolean wenchIsAligned = false;
     public amp() {
        this.s_shooterPigeon = s_shooterPigeon;
     }
   
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {

        Shooter.shooterSpeed = neededSpeed;

        //spin up shooter//
        Constants.shooterLeft.set(-neededSpeed);
        Constants.shooterRight.set(neededSpeed);


        if(shooterPigeon.roll > (neededAngle + yOffset)) {
            //enable shooter//
            //move left//
           Constants.wenchMotor.set(wenchNeededSpeed);
        } else if(shooterPigeon.roll < (neededAngle - yOffset)) {
            //move right//
            Constants.wenchMotor.set(-wenchNeededSpeed);
        } else {
            Constants.wenchMotor.set(0);
        }

        if(limelightSuckADick.idRead != -1 && wenchIsAligned) {
            //check limelight X position//
            if(limelightSuckADick.xValue > (neededXValue + xOffset)) {
                //enable shooter//
                //move left//
                TeleopSwerve.movementSpeedAutoStrafe = -alignSpeed;
            } else if(limelightSuckADick.xValue < (neededXValue - xOffset)) {
                //move right//
                TeleopSwerve.movementSpeedAutoStrafe = alignSpeed;
            } else {
                //stop//
                TeleopSwerve.movementSpeedAutoStrafe = 0;
            }
        }
        
    
}
}
