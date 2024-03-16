package frc.robot.aprilTagCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.commands.Shooter;
import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.limelightReadingTool;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.shooterPigeon;

public class stage extends Command {
    //specific values//
    double translationSupLocal;
    double rotationSupLocal;
    double strafeSupLocal;
    boolean robotCentricSupLocal = true;

    //offsets//
    private double xOffset = 4;
    private double yOffset = 3;

    // variable speeds//
    private double neededSpeed = .40;
    double alignSpeed = .1;
    double wenchNeededSpeed = .3;

    //specific needed values on different axis//
    double neededXValue = -1.7;
    double neededYValue = -5;

    //specific needed values for wench angle//
    double neededYValueWench = 60;
    double yOffsetWench = 3;

    //calling subsystems//
    private Swerve s_Swerve;
    private shooterPigeon s_ShooterPigeon;

    //booleans//
    Boolean wenchIsAligned;

    public static boolean stageIsAligned = false;

     public stage() {
       this.s_Swerve = s_Swerve;
       this.s_ShooterPigeon = s_ShooterPigeon;
     }
   
     @Override
     public void initialize() {}
    
     @Override
     public void execute() {
        Shooter.shooterSpeed = neededSpeed;

        //spin up shooter//
        Constants.shooterLeft.set(-neededSpeed);
        Constants.shooterRight.set(neededSpeed);

        if(shooterPigeon.roll > (neededYValueWench + yOffsetWench)) {
            wenchIsAligned = false;
           Constants.wenchMotor.set(wenchNeededSpeed);
        } else if(shooterPigeon.roll < (neededYValueWench - yOffsetWench)) {
            wenchIsAligned = false;
            Constants.wenchMotor.set(-wenchNeededSpeed);
        } else {
            Constants.wenchMotor.set(0);
            wenchIsAligned = true;
        }

        if(limelightReadingTool.idRead != -1 && wenchIsAligned) {
                if(limelightReadingTool.yValue > (neededYValue + yOffset)) {
                    //move up//
                    System.out.println("GO FORWARD");
                    stageIsAligned = false;
                } else if(limelightReadingTool.yValue < (neededYValue - yOffset)) {
                    //move down//
                    System.out.println("GO BACKWARD");
                    stageIsAligned = false;
                } else {
                    System.out.println("UR GOOD");
                    stageIsAligned = true;
                }
            }
        }

        

        
    }


