package frc.robot.commands.aprilTagCommands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.Swerve;
import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.limelightSuckADick;
import frc.robot.commands.wenchControl;

public class speaker extends Command {
    Translation2d newTranslation;
    private frc.robot.subsystems.Swerve s_Swerve = TeleopSwerve.s_Swerve;

    //specific values//
    double translationSupLocal;
    double rotationSupLocal;
    double strafeSupLocal;
    boolean robotCentricSupLocal = true;
     public speaker() {
     }
   
    
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {
        if(limelightSuckADick.yValue > (0 + 2) && wenchControl.wenchPID < 0) {
            Constants.wenchMotor.set(.25);
            controlMovement();
        } else if(limelightSuckADick.yValue < (0 - 2) && wenchControl.wenchPID > -118) {
            Constants.wenchMotor.set(-.25);
            controlMovement();
        } else {
            Constants.wenchMotor.set(0);
        }
    }

    void controlMovement() {
        s_Swerve.drive(
        new Translation2d(translationSupLocal/2, strafeSupLocal/2).times(Constants.Swerve.maxSpeed),
        rotationSupLocal * Constants.Swerve.maxAngularVelocity,
        !robotCentricSupLocal,
        true);
  }
}

