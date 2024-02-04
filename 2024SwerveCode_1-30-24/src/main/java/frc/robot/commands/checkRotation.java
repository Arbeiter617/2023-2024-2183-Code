package frc.robot.commands;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.Pigeon2Configuration;
import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.proximitySens;

public class checkRotation extends Command {
    public Pigeon2 gyroShooter; 
    public StatusSignal<Double> yawAmount;
    public double rotationAmount;
     public checkRotation() {
        
     }
   
    
     @Override
     public void initialize() {
        gyroShooter = new Pigeon2(Constants.pigeonIDShooter);
        gyroShooter.getConfigurator().apply(new Pigeon2Configuration());
        gyroShooter.setYaw(0);
     }
   
     
     @Override
     public void execute() {
        yawAmount = gyroShooter.getYaw();
        rotationAmount = gyroShooter.getAngle();
    }
}
