package frc.robot.aprilTagCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.commands.Shooter;
import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.limelightReadingTool;
import frc.robot.subsystems.shooterPigeon;

public class amp extends Command {
    //variable speeds//
    double neededSpeed = .225;
    double alignSpeed = .1;
    double wenchNeededSpeed = .65;
    public static double outakeSpeed = .3;

    //needed specific angles//
    double neededAngle = 50;

    //offsets//
    private double yOffset = 2;
    private double xOffset = 2;

    //specific values on the axis//
    double neededYValue = 10;
    double neededXValue = 0;

    //booleans//
    boolean wenchIsAligned = false;

    //calling subsystems//
    shooterPigeon s_shooterPigeon;

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
           Constants.wenchMotor.set(wenchNeededSpeed);
           wenchIsAligned = false;
        } else if(shooterPigeon.roll < (neededAngle - yOffset)) {
            Constants.wenchMotor.set(-wenchNeededSpeed);
            wenchIsAligned = false;
        } else {
            Constants.wenchMotor.set(0);
            wenchIsAligned = true;
        }

        ////TO USE THIS FEATURE, SET "drivepls" TO TRUE IN "readAprilTags" FILE////
        if(limelightReadingTool.idRead != -1 && wenchIsAligned) {
            //check limelight X position//
            if(limelightReadingTool.xValue > (neededXValue + xOffset)) {
                //move left//
                TeleopSwerve.movementSpeedAutoStrafe = alignSpeed;
            } else if(limelightReadingTool.xValue < (neededXValue - xOffset)) {
                //move right//
                TeleopSwerve.movementSpeedAutoStrafe = -alignSpeed;
            } else {
                //stop//
                TeleopSwerve.movementSpeedAutoStrafe = 0;
            }
        }
    /////////////////////////////////////////////////////////////////////////////
        
    
    }
}
