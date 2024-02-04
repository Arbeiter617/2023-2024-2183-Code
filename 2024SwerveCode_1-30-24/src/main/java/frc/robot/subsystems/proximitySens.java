// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.simulation.AnalogOutputSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;

public class proximitySens extends SubsystemBase {
  public static AnalogInput ring;
  //public static Double testNum = 0.0;
  
  /** Creates a new UpUp. */
  public proximitySens() {
    ring = new AnalogInput(0);
      
    };

  

  public void changeSensor (){
   ring.getValue();
  }
 
  
  @Override
  public void periodic() {
    // SmartDashboard.putNumber("Ring in or not?", proximitySens.ring.getValue() );
    // SmartDashboard.putNumber("Test Number", testNum.floatValue() );
    // This method will be called once per scheduler run
  }


}
