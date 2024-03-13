package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CANdleSystem;
import frc.robot.subsystems.colorSensor;

public class operateCANdle extends Command {
     CANdleSystem s_CANdleSystem;
    
     public operateCANdle() {
        this.s_CANdleSystem = s_CANdleSystem;
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
    //   if(RobotContainer.driver.getRawButton(1)) {
    //     s_CANdleSystem.setColors();
    //   }

    }
}
