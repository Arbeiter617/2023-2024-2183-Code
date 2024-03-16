package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class climber extends Command {

  public static double leftSpeed = .25;
  public static double rightSpeed = .25;
     public climber() {
       
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
      if(!toggleLiemlight.toggleAutoClimb && !RobotContainer.pitController.getRawButton(6)) {
      //left side//
      
        if(RobotContainer.driver.getRawAxis(2) > 0) {
        //arm down//
        Constants.climberLeft.set(RobotContainer.driver.getRawAxis(2));
       } else if(RobotContainer.driver.getRawButton(5)) {
        //arm up//
        Constants.climberLeft.set(-leftSpeed + (-.5));
       } else {
        //stop//
        Constants.climberLeft.set(0);
       }
       

       //right side//
        if(RobotContainer.driver.getRawAxis(3) > 0) {
        //arm down//
        Constants.climberRight.set(RobotContainer.driver.getRawAxis(3));
       }else if(RobotContainer.driver.getRawButton(6)) {
        //arm up//
        Constants.climberRight.set(-rightSpeed + -.5);
       } else {
        //stop//
        Constants.climberRight.set(0);
       }
       }

      }
        
    
}
