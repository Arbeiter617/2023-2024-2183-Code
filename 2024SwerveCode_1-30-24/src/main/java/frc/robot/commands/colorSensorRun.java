package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.colorSensor;
import frc.robot.subsystems.proximitySens;

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
      }
      else{
         pieceIsFound = false;
      }

    }
}
