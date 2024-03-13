// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.commands.PathPlannerAuto;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.lib.config.CTREConfigs;
import frc.robot.commands.Shooter;
import frc.robot.commands.colorSensorRun;
import frc.robot.pitCommands.pitCommandsFile;
import frc.robot.subsystems.CANdleSystem;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static CTREConfigs ctreConfigs;
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;
  Thread m_visionThread;


  //encoders//
   public static RelativeEncoder intakeUpEncoder;
   //public static RelativeEncoder wenchEncoder;

   //auto chooser//
   private static final String kTwoPiece = "Two Piece";
   private static final String kThreePiece = "Three Piece";
   private static final String kMiddlePieces = "Middle Pieces";
   private static final String kFourPieces = "4 Pieces";
   private static final String kFourPieceMiddle = "F2M5";
   private static final String kFourPieceMiddleL = "F3M5";
   private static final String kThreePieceMiddleR = "F1M3";
   private static final String kFourPieceMiddleR = "F1M5M4";
   private static final String kFourPieceRightSide = "4PieceRight";
   private static final String kChaosAuto = "chaosAuto";
   private static final String kTestFivePiece = "Test5Piece";
   public static String m_autoSelected;
   private final SendableChooser<String> autoChooser = new SendableChooser<>();

   public static String grantString = "Grant";
   public static String peytonStrin = "Peyton";
   //driver chooser//
   private static final String kPeyton = "Peyton";
   private static final String kGrant = "Grant";
   public static String m_driverSelected;
   private final SendableChooser<String> driverChooser = new SendableChooser<>();

   //LED bumper color chooser//
   private static final String kBlue = "Blue Team";
   private static final String kRed = "Red Team";
   private static final String kPractice = "Practice Match";
   private static final String kPits = "Pit Mode";
   public static String m_colorSelected;
   private final SendableChooser<String> colorChooser = new SendableChooser<>();

   AddressableLED m_led;
   AddressableLEDBuffer m_ledBuffer;
   int m_rainbowFirstPixleHue;

   double startTime;
   double currentTime;
   double startTime2;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    ctreConfigs = new CTREConfigs();
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    //Constants.compress.enableDigital();

    ////start LEDs////
    // PWM port 9
    // Must be a PWM header, not MXP or DIO
    m_led = new AddressableLED(9);

    // Reuse buffer
    // Default to a length of 60, start empty output
    // Length is expensive to set, so only set it once, then just update data
    m_ledBuffer = new AddressableLEDBuffer(60);
    m_led.setLength(m_ledBuffer.getLength());
    m_led.start();
    ////////////////

    intakeUpEncoder = Constants.intakeMotorUp.getEncoder();

    autoChooser.addOption("4 Pieces", kFourPieces);
    autoChooser.addOption("4 Piece Right", kFourPieceRightSide);
    autoChooser.addOption("F2M5", kFourPieceMiddle);
    autoChooser.addOption("F3M5", kFourPieceMiddleL);
    autoChooser.addOption("Test5Piece", kTestFivePiece);
    autoChooser.addOption("chaosAuto", kChaosAuto);
    SmartDashboard.putData("Auto Selected:", autoChooser);
    m_autoSelected = autoChooser.getSelected();

    //set driver//
    driverChooser.addOption("Peyton", kPeyton);
    driverChooser.addOption("Grant", kGrant);
    SmartDashboard.putData("Driver Selected:", driverChooser);
    m_driverSelected = driverChooser.getSelected();

    //set color//
    colorChooser.addOption("Blue Team", kBlue);
    colorChooser.addOption("Red Team", kRed);
    colorChooser.addOption("Practice Match", kPractice);
    colorChooser.addOption("Pits Mode", kPits);
    SmartDashboard.putData("Color Selected:", colorChooser);
    m_colorSelected = colorChooser.getSelected();

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    

    if(Robot.m_driverSelected == Robot.peytonStrin) {
      RobotContainer.translationAxis = PS5Controller.Axis.kLeftY.value;
    RobotContainer.strafeAxis = PS5Controller.Axis.kLeftX.value;
    RobotContainer.rotationAxis = PS5Controller.Axis.kRightX.value;
    } else {
      RobotContainer.translationAxis = XboxController.Axis.kLeftY.value;
    RobotContainer.strafeAxis = XboxController.Axis.kLeftX.value;
    RobotContainer.rotationAxis = XboxController.Axis.kRightX.value;
    }
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
    RobotContainer.driver.setRumble(RumbleType.kLeftRumble, 0);
  }

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autoSelected = autoChooser.getSelected();
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    //run color sensor file//
    RobotContainer.colorSensorRun.execute();
    RobotContainer.limelightSuckADick.execute();
    RobotContainer.autoLimelight.execute();

    //run some lights//
    //autoColor();
  }

  @Override
  public void teleopInit() {
    startTime = System.currentTimeMillis();
    startTime2 = System.currentTimeMillis();

    m_driverSelected = driverChooser.getSelected();
    m_colorSelected = colorChooser.getSelected();

    //Robot.wenchEncoder.setPosition(0);
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    strobe();
    //smart dashboard called//
    //SmartDashboard.putNumber("Intake Encoder Position", intakeUpEncoder.getPosition());
    // SmartDashboard.putNumber("Wench Encoder Position", wenchEncoder.getPosition());
    SmartDashboard.putBoolean("Piece?", colorSensorRun.pieceIsFound);
    // SmartDashboard.putNumber("ServoAngle:", camControl.camAngle);
    // SmartDashboard.putNumber("Piston Angle:", Constants.actionPiston2.getAngle());
    //SmartDashboard.putNumber("previous distance:", limelightSuckADick.prev_distance);
    //SmartDashboard.putNumber("Shooter Speed: ", Shooter.shooterSpeed);
    // SmartDashboard.putNumber("Transform distance", TeleopSwerve.translationVal);
    //SmartDashboard.putString("Auto Enabled: ", autoCommands.autoCommandString);

    //run command inputs//
    RobotContainer.shooter.execute();
    RobotContainer.intake.execute();
    RobotContainer.PieceRetard.execute();
    RobotContainer.CamControl.execute();
    RobotContainer.wenchControl.execute();
    RobotContainer.limelightSuckADick.execute();
    RobotContainer.colorSensorRun.execute();
    RobotContainer.readAprilTags.execute();
    RobotContainer.toggleLiemlight.execute();
    RobotContainer.climber.execute();
    RobotContainer.operateCANdle.execute();
    RobotContainer.speedInputsDriver.execute();
    RobotContainer.pitCommandsFile.execute();
    

  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  private void strobe() {
    if(!pitCommandsFile.isTesting) {
    if(colorChooser.getSelected() == kBlue) {
      if(colorSensorRun.pieceIsFound) {
        if(System.currentTimeMillis() > startTime + 250) {
          //System.out.println("200");
          for(var i = 0; i < m_ledBuffer.getLength(); i++) {
            m_ledBuffer.setRGB(i, 102, 51, 0);
          }

      if(System.currentTimeMillis() > startTime + 500) {
        startTime = System.currentTimeMillis();
      }
      
    } else {
      for(var i = 0; i < m_ledBuffer.getLength(); i++) {
         m_ledBuffer.setRGB(i, 153, 0, 153);
         
      }
    }
      } else {
        for(var i = 0; i < m_ledBuffer.getLength(); i++) {
         m_ledBuffer.setRGB(i, 0, 0, 255);
         
      }
      }
    } else if(colorChooser.getSelected() == kRed) {
      if(colorSensorRun.pieceIsFound) {
        if(System.currentTimeMillis() > startTime + 250) {
          ///System.out.println("200");
          for(var i = 0; i < m_ledBuffer.getLength(); i++) {
            m_ledBuffer.setRGB(i, 102, 51, 0);
          }

      if(System.currentTimeMillis() > startTime + 500) {
        startTime = System.currentTimeMillis();
      }
      
    } else {
      for(var i = 0; i < m_ledBuffer.getLength(); i++) {
         m_ledBuffer.setRGB(i, 153, 0, 153);
         
      }
    }
      } else {
        for(var i = 0; i < m_ledBuffer.getLength(); i++) {
         m_ledBuffer.setRGB(i, 255, 0, 0);
         
      }
      }
    } else if(colorChooser.getSelected() == kPractice) {
      if(colorSensorRun.pieceIsFound) {
        if(System.currentTimeMillis() > startTime + 250) {
          //System.out.println("200");
          for(var i = 0; i < m_ledBuffer.getLength(); i++) {
            m_ledBuffer.setRGB(i, 102, 51, 0);
          }

      if(System.currentTimeMillis() > startTime + 500) {
        startTime = System.currentTimeMillis();
      }
      
    } else {
      for(var i = 0; i < m_ledBuffer.getLength(); i++) {
         m_ledBuffer.setRGB(i, 153, 0, 153);
         
      }
    }
      } else {
        for(var i = 0; i < m_ledBuffer.getLength(); i++) {
         m_ledBuffer.setRGB(i, 255, 0, 255);
         
      }
      }
    }else {
      for(var i = 0; i < m_ledBuffer.getLength(); i++) {
         m_ledBuffer.setRGB(i, 255, 255, 255);
         
      }
    }
  } else {
    if(System.currentTimeMillis() > startTime + 500) {
          for(var i = 0; i < m_ledBuffer.getLength(); i++) {
            m_ledBuffer.setRGB(i, 255, 0, 0);
          }

      if(System.currentTimeMillis() > startTime + 1000) {
        startTime = System.currentTimeMillis();
      }
      
    } else {
      for(var i = 0; i < m_ledBuffer.getLength(); i++) {
         m_ledBuffer.setRGB(i, 0, 0, 0);
         
      }
    }
  }

  m_led.setData(m_ledBuffer);
  }
}
