package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.proximitySens;

public class wenchControl extends Command {
    public int povNumbers;
    public static double wenchPID;
     public wenchControl() {
        
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        wenchPID = Robot.wenchEncoder.getPosition();
        povNumbers = RobotContainer.copilot.getPOV();
    if(!toggleLiemlight.toggleLimelightPos) {
        if(povNumbers == 0 && wenchPID < 0) {
            //wench up//
            Constants.wenchMotor.set(1);
        } else if(povNumbers == 180 && wenchPID > -68) {
            //wench down//
            Constants.wenchMotor.set(-1);
        } else {
            //wench stop//
            Constants.wenchMotor.set(0);
        }

    }

        
    }
}
