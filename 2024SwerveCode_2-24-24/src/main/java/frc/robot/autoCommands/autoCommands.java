package frc.robot.autoCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.Shooter;

public class autoCommands extends Command {
    public static String autoCommandString;
     public autoCommands() {
        
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        
        if(RobotContainer.copilot.getRawButton(7)) {
            //auto shoot function//
            try {
                autoCommandString = "Auto Shoot Starting...";
                Constants.shooterLeft.set(Shooter.shooterSpeed);
                Constants.shooterRight.set(-Shooter.shooterSpeed);
                wait(1000);
                Constants.intakeMotorIn.set(-.8);
                wait(500);
                Constants.intakeMotorIn.set(0);
                Constants.shooterLeft.set(0);
                Constants.shooterRight.set(0);
                autoCommandString = "Auto Shoot Done...";

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            autoCommandString = "No Auto Mode Selected";
        }
    }
}
