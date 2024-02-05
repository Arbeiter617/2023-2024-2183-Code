package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class readAprilTags extends Command {
    double specificID;

    //all tag IDs//
    double redStageTag = 12;
    double redAmpTag = 5;
    double redsSpeakerTag = 3;

    double blueStageTag = 14;
    double blueAmpTag = 6;
    double blueSpeakerTag = 7;

     public readAprilTags() {
       
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        specificID =  limelightValuesRead.idRead;

        //check tags//
        if(toggleLiemlight.toggleLimelightPos) {
            //can position//
            if(specificID == redStageTag) {  
                //System.out.println("Red Stage");
                RobotContainer.stage.execute();
            } else if(specificID == redAmpTag) {
                //System.out.println("Red Amp");
                RobotContainer.amp.execute();
            } else if(specificID == redsSpeakerTag) {
                //System.out.println("Red Speaker");
                RobotContainer.speaker.execute();
            }
        }
    }
}
