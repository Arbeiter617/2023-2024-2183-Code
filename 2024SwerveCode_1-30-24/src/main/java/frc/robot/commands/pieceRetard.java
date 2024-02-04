package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.proximitySens;

public class pieceRetard extends Command {
     proximitySens s_ProximitySens;
        public static Boolean pieceIsFound = false;
     public pieceRetard() {
        this.s_ProximitySens = s_ProximitySens;
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
      //   if (proximitySens.ring.getValue() < 150){
      //      pieceIsFound = true;
      //   }
      //   else{
      //      pieceIsFound = false;
      //   }
    }
}
