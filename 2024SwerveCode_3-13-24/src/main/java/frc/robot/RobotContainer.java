package frc.robot;

import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.autoCommands.colorSensorIntake;
import frc.robot.autoCommands.intakeCommand;
import frc.robot.autoCommands.intakeMotorCommand;
import frc.robot.autoCommands.shooterCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static Boolean drivepls = false;

  /* Controllers */
  public final static Joystick driver = new Joystick(0);
  public final static Joystick copilot = new Joystick(1);
  public final static Joystick pitController = new Joystick(2);

  //call commands//
  public static Shooter shooter = new Shooter();
  public static Intake intake = new Intake();
  public static wenchControl wenchControl = new wenchControl();
  public static limelightReadingTool limelightReadingTool = new limelightReadingTool();
  public static colorSensorRun colorSensorRun = new colorSensorRun();
  public static readAprilTags readAprilTags = new readAprilTags();
  public static toggleLiemlight toggleLiemlight = new toggleLiemlight();
  public static climber climber = new climber();

  //april tags//
  public static frc.robot.aprilTagCommands.stage stage = new frc.robot.aprilTagCommands.stage();
  public static frc.robot.aprilTagCommands.amp amp = new frc.robot.aprilTagCommands.amp();
  public static frc.robot.aprilTagCommands.speaker speaker = new frc.robot.aprilTagCommands.speaker();
  public static frc.robot.autoCommands.autoLimelight autoLimelight = new frc.robot.autoCommands.autoLimelight();
  //driver//
  public static frc.robot.aprilTagCommandsDriver.stage driverStage = new frc.robot.aprilTagCommandsDriver.stage();
  public static frc.robot.pitCommands.pitCommandsFile pitCommandsFile = new frc.robot.pitCommands.pitCommandsFile();
  
    //array checker//
  public static frc.robot.checkAprilTag.checkingArray checkingArray = new frc.robot.checkAprilTag.checkingArray();
  //call subsystems//
  private final colorSensor s_ColorSensor = new colorSensor();
  private final shooterPigeon s_ShooterPigeon = new shooterPigeon();

  /* Drive Controls */
  static int translationAxis;
  static int strafeAxis;
  static int rotationAxis;

  /* Driver Buttons */
  private final JoystickButton zeroGyro =
      new JoystickButton(driver, XboxController.Button.kY.value);
  private final JoystickButton robotCentric =
      new JoystickButton(driver, XboxController.Button.kLeftBumper.value);

  /* Subsystems */
  private final Swerve s_Swerve = new Swerve();

 String singlePiece = "Single Piece";
 String twoPiece = "Two Piece";
 String threePiece = "Three Piece";
 String middlePiece = "Middle Pieces";
 String fourPiece = "4 Pieces";
 String fourPieceRight = "4PieceRight";
 String fourPieceMiddle = "F2M5";
 String fourPieceMiddleL = "F3M5";
 String kThreePieceMiddleR = "F1M3";
 String kFourPieceMiddleR = "F1M5M4";
 String kTest5Piece = "Test5Piece";
 String kChaosAuto = "chaosAuto";


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //auto commands//
      NamedCommands.registerCommand("shooterOn", new shooterCommand(1));
      NamedCommands.registerCommand("shooterOff", new shooterCommand(0));
      NamedCommands.registerCommand("intakeStopMotor", new intakeCommand(0, false).withTimeout(.25));
      NamedCommands.registerCommand("intakeUp", new intakeCommand(.25, false).withTimeout(1));
      NamedCommands.registerCommand("intakeDown", new intakeCommand(.15, true).withTimeout(.75));
      NamedCommands.registerCommand("intakeIn", new intakeMotorCommand(.5, true).withTimeout(.25));
      NamedCommands.registerCommand("intakeOut", new intakeMotorCommand(.5, false).withTimeout(.25));
      NamedCommands.registerCommand("intakeStop", new intakeMotorCommand(0, true).withTimeout(.5));
      NamedCommands.registerCommand("intakeColor", new colorSensorIntake(.5));

    s_Swerve.setDefaultCommand(
        new TeleopSwerve(
            s_Swerve,
            () -> -driver.getRawAxis(translationAxis),
            () -> -driver.getRawAxis(strafeAxis),
            () -> -driver.getRawAxis(rotationAxis),
            () -> robotCentric.getAsBoolean()));

    // Configure the button bindings
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    /* Driver Buttons */
    zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroGyro()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous

      if(Robot.m_autoSelected == twoPiece) {
        return new PathPlannerAuto("twoPiece");
      }else if(Robot.m_autoSelected == threePiece) {
        return new PathPlannerAuto("threePiece");
      }else if(Robot.m_autoSelected == middlePiece) {
        return new PathPlannerAuto("middlePieces");
      }else if(Robot.m_autoSelected == fourPiece) {
        return new PathPlannerAuto("4Piece");
      }else if(Robot.m_autoSelected == fourPieceMiddle) {
        return new PathPlannerAuto("F2M5");
      }else if(Robot.m_autoSelected == fourPieceMiddleL) {
        return new PathPlannerAuto("F3M5");
      }else if(Robot.m_autoSelected == kThreePieceMiddleR) {
        return new PathPlannerAuto("F1M3");
      }else if(Robot.m_autoSelected == kFourPieceMiddleR) {
        return new PathPlannerAuto("F1M5M4");
      }else if(Robot.m_autoSelected == kTest5Piece) {
        return new PathPlannerAuto("5PieceNew");
      }else if(Robot.m_autoSelected == fourPieceRight) {
        return new PathPlannerAuto("4PieceRight");
      }else if(Robot.m_autoSelected == kChaosAuto) {
        return new PathPlannerAuto("chaosAuto");
      }else {
        System.out.println("ERROR");
        return null;
      }
  }

}
