package frc.robot.commands;

import com.ctre.phoenix.led.ColorFlowAnimation;
import com.ctre.phoenix.led.ColorFlowAnimation.Direction;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CANdleSystem;
import frc.robot.subsystems.colorSensor;

public class colorSensorRun extends Command {
     colorSensor s_ColorSensor;
     CANdleSystem s_CaNdleSystem;
     static double colorSenorProx;
     public static Boolean pieceIsFound = false;
     public colorSensorRun() {
        this.s_ColorSensor = s_ColorSensor;
        this.s_CaNdleSystem = s_CaNdleSystem;
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
      //System.out.println(colorSensor.m_colorSensor.getProximity());
      if (colorSensor.m_colorSensor.getProximity() > 150){
         pieceIsFound = true;
         RobotContainer.driver.setRumble(RumbleType.kLeftRumble, 1);
         
         //color to strobe green and white//
         //CANdleSystem.LEDSegment.MainStrip.setFadeAnimation(CANdleSystem.orange, 1);
      }
      else{
         pieceIsFound = false;
         RobotContainer.driver.setRumble(RumbleType.kLeftRumble, 0);
         //color strobe purple and gold//
         if(!Shooter.fireToggle) {
            //System.out.println("Should be purple");
            //CANdleSystem.LEDSegment.MainStrip.setFadeAnimation(CANdleSystem.purple, .5);
         }
      }

    }
}
