package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class readAprilTags extends Command {
    public static double specificID;

    //all tag IDs//
    double redStageTag = 12;
    double redAmpTag = 5;
    public static double redsSpeakerTag = 3;

    double blueStageTag = 14;
    double blueAmpTag = 6;
    double blueSpeakerTag = 7;

     public readAprilTags() {
       
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        specificID =  limelightSuckADick.idRead;

        //check tags//
        if(toggleLiemlight.toggleLimelightPos && specificID != -1) {
            
            if(specificID == redStageTag || specificID == blueStageTag) {
                RobotContainer.drivepls = true;
                RobotContainer.stage.execute();
            } else if(specificID == redAmpTag || specificID == blueAmpTag) {
                RobotContainer.drivepls = true;
               RobotContainer.amp.execute();
            } else if(specificID == redsSpeakerTag || specificID == blueSpeakerTag) {
                RobotContainer.drivepls = false;
                RobotContainer.speaker.execute();

            } 
        } else if(toggleLiemlight.toggleDriverLimelightPos && specificID != -1) {
            if(specificID == redStageTag || specificID == blueStageTag) {
                RobotContainer.driverStage.execute();
            }

        } else {
            RobotContainer.drivepls = false;
            
            toggleLiemlight.toggleLimelightPos = false;
            
        }
        
    }
}
