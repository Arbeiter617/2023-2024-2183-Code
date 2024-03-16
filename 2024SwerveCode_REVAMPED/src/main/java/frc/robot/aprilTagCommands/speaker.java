package frc.robot.aprilTagCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.commands.limelightReadingTool;
import frc.robot.commands.readAprilTags;
import frc.robot.commands.toggleLiemlight;

public class speaker extends Command {
    //specific values on axis//
    double centerXValue = 0;
    double centerYValue = -22;
    
    //offsets//
    double yOffset = 2;
    double xOffset = 2;

    //variable speeds//
    double wenchNeededSpeed = .45;
    double rotationSpeed = .1;

    double[] speakerAprilTag = {7, 4, 3, 8};
    
    public static double neededSpeed = 1;
    public static boolean isSpeaker = false;
    boolean runSpeakerAlgorithim = false;

     public speaker() {}
   
     @Override
     public void initialize() {}
   
     @Override
     public void execute() {
    Constants.shooterLeft.set(-neededSpeed);
    Constants.shooterRight.set(neededSpeed);

    System.out.println(isSpeaker);
    System.out.println(limelightReadingTool.yValue + "?" + centerYValue);

    if(limelightReadingTool.idRead != -1 && toggleLiemlight.toggleLimelightPos) {
        for(var i = 0; i < speakerAprilTag.length; i++) {
            if(speakerAprilTag[i] == readAprilTags.specificID) {
                isSpeaker = true;
            } else {
                isSpeaker = false;
            }
        }
    }

    if(toggleLiemlight.toggleLimelightPos) {
        if(isSpeaker) {
         System.out.println("Printing from file INSIDE idRead IF");
            if(limelightReadingTool.yValue > (centerYValue + yOffset)) {
             Constants.wenchMotor.set(-wenchNeededSpeed);
             } else if(limelightReadingTool.yValue < (centerYValue - yOffset)) {
             Constants.wenchMotor.set(wenchNeededSpeed);
            } else {
             Constants.wenchMotor.set(0);
            }  
        } else {
            if(limelightReadingTool.idRead != -1) {
                System.out.println("Should only run when it cant see ANY april tag");
                Constants.wenchMotor.set(wenchNeededSpeed);
            }
        }
    }
 }
}

