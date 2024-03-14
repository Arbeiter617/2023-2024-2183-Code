package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
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
        if(toggleLiemlight.toggleLimelightPos && specificID != 0) {
            
            //can position//
            if(specificID == redStageTag) {
                //System.out.println("Red Stage");
                //NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
                RobotContainer.drivepls = true;
                RobotContainer.stage.execute();
            } else if(specificID == redAmpTag) {
                //System.out.println("Red Amp");
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
                RobotContainer.drivepls = false;
               RobotContainer.amp.execute();
            } else if(specificID == redsSpeakerTag) {
                //System.out.println("Red Speaker");
                //set pos//
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
                RobotContainer.drivepls = false;
                RobotContainer.speaker.execute();

            } 
        } else {
            RobotContainer.drivepls = false;
            
            toggleLiemlight.toggleLimelightPos = false;
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
            
        }

        //run auto climb//
        
    }
}
