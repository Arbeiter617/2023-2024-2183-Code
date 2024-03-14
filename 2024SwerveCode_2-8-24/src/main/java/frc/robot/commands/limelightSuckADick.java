package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class limelightSuckADick extends Command {
    public static double prev_distance = 0;
    public static double idRead;
    public static double xValue;
    public static double yValue;
    public static double areaValue;
     public limelightSuckADick() {
        
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");
        NetworkTableEntry id = table.getEntry("tid");

        //read values periodically
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);
        idRead = id.getDouble(0.0);
        xValue = x;
        yValue = y;
        areaValue = area;
        
        //post to smart dashboard periodically
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
        SmartDashboard.putNumber("ID", idRead);


        //limelight shooter logic//
         double distance = area; // get distance
    // if(area != 0) {
    //     if(prev_distance == 0) {
    //         prev_distance = area;
    //     } else {
    //         if(distance + .05 < (prev_distance)) {
    //             //System.out.println("Shoot Harder");

    //             Constants.wenchMotor.set(.15);
    //         } else if(distance -.05 > (prev_distance)) {
    //              //System.out.println("Shoot Softer");
    //              Constants.wenchMotor.set(-.15);
    //         }  else {
    //             //System.out.println("Calculating...");
    //             Constants.wenchMotor.set(0);
    //         }
    //         prev_distance = distance; // remember this distance for next time
    //     }
    // } else {
    //     //System.out.println("Nothing Found");
    // }

    }
}
