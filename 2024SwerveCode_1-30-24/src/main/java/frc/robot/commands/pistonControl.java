package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class pistonControl extends Command {
     private int povNumbers;
     double angle;
     public pistonControl() {
       
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        povNumbers = RobotContainer.copilot.getPOV();

        //control servo//
        if(povNumbers == 0) {
            //servo left//
            if(angle < 165) {
                angle = angle + 1;
            }

        } else if(povNumbers == 180) {
            angle = angle - 1;
        }else {
            //servo in the middle//
           
        }

        Constants.actionPiston1.setAngle(angle);
        Constants.actionPiston2.setAngle(angle);

        
    }
}
