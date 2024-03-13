package frc.robot.aprilTagCommands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.Swerve;
import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.limelightSuckADick;
import frc.robot.commands.toggleLiemlight;
import frc.robot.commands.wenchControl;

public class speaker extends Command {
    Translation2d newTranslation;
    //specific values//
    double translationSupLocal = 1;
    double rotationSupLocal;
    double strafeSupLocal;
    boolean robotCentricSupLocal = true;

    double centerXValue = 0;
    double centerYValue = -21;

    double centerXValueFar = 0;
    double centerYValueFar = -20;
    //wench values//
    double yOffset = 2;
    double wenchNeededSpeed = .6;

    //turn values;;
    double xOffset = 2;
    double rotationSpeed = .1;

    //speeds//
    public static double neededSpeed;

     public speaker() {}
   
     @Override
     public void initialize() {}
   
     @Override
     public void execute() {
        // neededSpeedL = 1;
        // neededSpeedR = 1;

        // //spin up shooter//
        // Constants.shooterLeft.set(-neededSpeedL);
        // Constants.shooterRight.set(neededSpeedR);

        if(limelightSuckADick.areaValue > .5) {
            neededSpeed = .6;
        } else if(limelightSuckADick.areaValue <= .5 && limelightSuckADick.areaValue != 0.0){
           neededSpeed = 1;
        }


        //System.out.println(neededSpeed);
        System.out.println(neededSpeed);

        Constants.shooterLeft.set(-neededSpeed);
        Constants.shooterRight.set(neededSpeed);
                

    if(limelightSuckADick.idRead != -1) {
        if(limelightSuckADick.areaValue > .14) {
            if(limelightSuckADick.yValue > (centerYValue + yOffset)) {
             Constants.wenchMotor.set(-wenchNeededSpeed);
             } else if(limelightSuckADick.yValue < (centerYValue - yOffset)) {
             Constants.wenchMotor.set(wenchNeededSpeed);
            } else {
             Constants.wenchMotor.set(0);
        }
        } else if(limelightSuckADick.areaValue <= .14){
            if(limelightSuckADick.yValue > (centerYValueFar + yOffset)) {
             Constants.wenchMotor.set(-wenchNeededSpeed);
             } else if(limelightSuckADick.yValue < (centerYValueFar - yOffset)) {
             Constants.wenchMotor.set(wenchNeededSpeed);
            } else {
             Constants.wenchMotor.set(0);
            }
        }   


    } 
 }
}

