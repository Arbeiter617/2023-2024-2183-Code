package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.aprilTagCommands.stage;

public class readAprilTags extends Command {
    public static double specificID;
    public static boolean isStage = false;
    public static boolean isAmp = false;
    public static boolean isSpeaker = false;
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
            if(isStage) {
                //System.out.println("Red Stage");
                //NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
                RobotContainer.drivepls = true;
                RobotContainer.stage.execute();
            } else if(isAmp) {
                //System.out.println("Red Amp");
                //NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
                RobotContainer.drivepls = false;
               RobotContainer.amp.execute();
            } else if(isSpeaker) {
                //System.out.println("Red Speaker");
                //set pos//
                //NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
                RobotContainer.drivepls = false;
                RobotContainer.speaker.execute();

            } 
        } else {
            RobotContainer.drivepls = false;
            //NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
            
        }

        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
        
    }
}
