package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.commands.colorSensorRun;
import frc.robot.subsystems.CANdleSystem;
import frc.robot.subsystems.colorSensor;

public class colorSensorIntake extends Command {
    double speed;
     public colorSensorIntake(double speed) {
       this.speed = speed;;
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
      System.out.println("HELP");
        if(!colorSensorRun.pieceIsFound) {
          Constants.intakeMotorIn.set(-speed);
        } else {
          Constants.intakeMotorIn.set(0);
        }
      


    }
}
