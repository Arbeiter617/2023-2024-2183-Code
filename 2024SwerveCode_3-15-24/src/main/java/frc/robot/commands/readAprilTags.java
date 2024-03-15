package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class readAprilTags extends Command {
    public static double specificID;
    public static boolean isStage = false;
    public static boolean isAmp = false;
    public static boolean isSpeaker = false;

    public readAprilTags() {}

     @Override
    public void initialize() {}
     
     @Override
    public void execute() {
        specificID = limelightReadingTool.idRead;    

        //check tags//
        if(toggleLiemlight.toggleLimelightPos && specificID != 0) {
            if(isStage) {
                RobotContainer.drivepls = false;
                RobotContainer.stage.execute();
            } else if(isAmp) {
                RobotContainer.drivepls = true;
               RobotContainer.amp.execute();
            } else if(isSpeaker) {
                RobotContainer.drivepls = false;
                RobotContainer.speaker.execute();
            } 
        } else {
            RobotContainer.drivepls = false;
        }

        //setting the default to be LEDs ON//
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
        
    }
}
