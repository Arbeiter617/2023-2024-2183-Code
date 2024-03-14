package frc.robot.commands;

import com.ctre.phoenix.led.ColorFlowAnimation;
import com.ctre.phoenix.led.ColorFlowAnimation.Direction;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CANdleSystem;
import frc.robot.subsystems.colorSensor;

public class driverSpeedInputs extends Command {
     private double precissionModeSpeed = 2.5;
     private double speedyWeenieSpeed = 6.5;
     private double normalSpeed = 8;
     public driverSpeedInputs() {
        
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
      // if(RobotContainer.driver.getRawButton(1)) {
      //   //speedy//

      //   Constants.Swerve.maxSpeed = speedyWeenieSpeed;
      // } else if(RobotContainer.driver.getRawButton(4)) {
      //   //slowly//
      //   Constants.Swerve.maxSpeed = precissionModeSpeed;
      // } else {
      //   //normal//
      //   Constants.Swerve.maxSpeed = normalSpeed;
      // }

      //System.out.println(Constants.Swerve.maxSpeed);

    }
}
