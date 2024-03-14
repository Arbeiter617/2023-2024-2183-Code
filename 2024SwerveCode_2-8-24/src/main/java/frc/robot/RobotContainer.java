package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.autos.*;
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

  //call commands//
  public static Shooter shooter = new Shooter();
  public static Intake intake = new Intake();
  public static pieceRetard PieceRetard = new pieceRetard();
  public static camControl CamControl = new camControl();
  public static wenchControl wenchControl = new wenchControl();
  public static limelightSuckADick limelightSuckADick = new limelightSuckADick();
  public static colorSensorRun colorSensorRun = new colorSensorRun();
  public static readAprilTags readAprilTags = new readAprilTags();
  public static toggleLiemlight toggleLiemlight = new toggleLiemlight();
  public static climber climber = new climber();
  public static operateCANdle operateCANdle = new operateCANdle();

  //april tags//
  public static frc.robot.aprilTagCommands.stage stage = new frc.robot.aprilTagCommands.stage();
  public static frc.robot.aprilTagCommands.amp amp = new frc.robot.aprilTagCommands.amp();
  public static frc.robot.aprilTagCommands.speaker speaker = new frc.robot.aprilTagCommands.speaker();

  //driver april tags//
  public static frc.robot.aprilTagCommandsDriver.stage driverStage = new frc.robot.aprilTagCommandsDriver.stage();

  //call subsystems//
  private final colorSensor s_ColorSensor = new colorSensor();
  private final shooterPigeon s_ShooterPigeon = new shooterPigeon();
  public static final CANdleSystem m_candleSubsystem = new CANdleSystem();

  /* Drive Controls */
  private final int translationAxis = XboxController.Axis.kLeftY.value;
  private final int strafeAxis = XboxController.Axis.kLeftX.value;
  private final int rotationAxis = XboxController.Axis.kRightX.value;

  /* Driver Buttons */
  private final JoystickButton zeroGyro =
      new JoystickButton(driver, XboxController.Button.kY.value);
  private final JoystickButton robotCentric =
      new JoystickButton(driver, XboxController.Button.kLeftBumper.value);

  /* Subsystems */
  private final Swerve s_Swerve = new Swerve();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
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
    return new twoPieceTest();
  }
}
