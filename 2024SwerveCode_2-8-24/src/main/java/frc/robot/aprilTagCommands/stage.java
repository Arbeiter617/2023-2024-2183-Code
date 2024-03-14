package frc.robot.aprilTagCommands;

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
    Translation2d newTranslation;
    //private frc.robot.subsystems.Swerve s_Swerve = TeleopSwerve.s_Swerve;

    //specific values//
    double translationSupLocal;
    double rotationSupLocal;
    double strafeSupLocal;
    boolean robotCentricSupLocal = true;

    //offsets//
    private double xOffset = 4;
    private double yOffset = 3;
    private double angleOffset = 5;

    private double neededAngle = 165;
    private double neededSpeed = .43;

    double neededXValue = -1.7;
    double neededYValue = -5;

    double neededYValueWench = 54;
    double yOffsetWench = 3;

    double alignSpeed = .1;
    double wenchNeededSpeed = .45;

    private Swerve s_Swerve;
    private shooterPigeon s_ShooterPigeon;

    Boolean wenchIsAligned;

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
            //enable shooter//
            //move left//
            wenchIsAligned = false;
            //System.out.println("going down");
           Constants.wenchMotor.set(wenchNeededSpeed);
        } else if(shooterPigeon.roll < (neededYValueWench - yOffsetWench)) {
            //move right//
            wenchIsAligned = false;
            //System.out.println("going up");
            Constants.wenchMotor.set(-wenchNeededSpeed);
        } else {
            Constants.wenchMotor.set(0);
            System.out.println("stop");
            wenchIsAligned = true;
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
                //check liemlight y position//
                if(limelightSuckADick.yValue > (neededYValue + yOffset)) {
                    //move up//
                    TeleopSwerve.movementSpeedAutoTransform = -alignSpeed;
                } else if(limelightSuckADick.yValue < (neededYValue - yOffset)) {
                    //move down//
                    TeleopSwerve.movementSpeedAutoTransform = alignSpeed;
                } else {
                    TeleopSwerve.movementSpeedAutoTransform = 0;

                }
            }
        }

        
    }

}
