package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.colorSensor;

public class colorSensorRun extends Command {
     colorSensor s_ColorSensor;
     static double colorSenorProx;
     public static Boolean pieceIsFound = false;
     public colorSensorRun() {
        this.s_ColorSensor = s_ColorSensor;
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
      if (colorSensor.m_colorSensor.getProximity() > 150){
         pieceIsFound = true;
         RobotContainer.driver.setRumble(RumbleType.kLeftRumble, 1);
      }
      else{
         pieceIsFound = false;
         RobotContainer.driver.setRumble(RumbleType.kLeftRumble, 0);
      }

    }
}
