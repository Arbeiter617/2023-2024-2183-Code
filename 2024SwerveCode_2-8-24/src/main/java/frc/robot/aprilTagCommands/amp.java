package frc.robot.aprilTagCommands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.Shooter;
import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.limelightSuckADick;
import frc.robot.commands.readAprilTags;
import frc.robot.commands.toggleLiemlight;
import frc.robot.commands.wenchControl;
import frc.robot.subsystems.shooterPigeon;

public class amp extends Command {
    Translation2d newTranslation;
    shooterPigeon s_shooterPigeon;
    //private frc.robot.subsystems.Swerve s_Swerve = TeleopSwerve.s_Swerve;

    //58 deg//

    //specific values//
    double translationSupLocal;
    double rotationSupLocal;
    double strafeSupLocal;
    boolean robotCentricSupLocal = true;

    double neededSpeed = .5;
    double neededAngle = 51;

    private double yOffset = 2;
    double neededYValue = 10;

    double wenchNeededSpeed = .35;
     public amp() {
        this.s_shooterPigeon = s_shooterPigeon;
     }
   
     @Override
     public void initialize() {}
   
     
     @Override
     public void execute() {

        Shooter.shooterSpeed = neededSpeed;

        if(shooterPigeon.roll > (neededAngle + yOffset)) {
            //enable shooter//
            //move left//
           Constants.wenchMotor.set(wenchNeededSpeed);
        } else if(shooterPigeon.roll < (neededAngle - yOffset)) {
            //move right//
            Constants.wenchMotor.set(-wenchNeededSpeed);
        } else {
            Constants.wenchMotor.set(0);
        }
        
    
}
}
