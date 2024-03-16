package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Swerve;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class TeleopSwerve extends Command {
  private Swerve s_Swerve;
  private DoubleSupplier translationSup;
  private DoubleSupplier strafeSup;
  private DoubleSupplier rotationSup;
  private BooleanSupplier robotCentricSup;

  private SlewRateLimiter translationLimiter = new SlewRateLimiter(3.0);
  private SlewRateLimiter strafeLimiter = new SlewRateLimiter(3.0);
  private SlewRateLimiter rotationLimiter = new SlewRateLimiter(3.0);

  public static double translationVal;
  public static double strafeVal;
  public static double rotationVal;

  public static double movementSpeedAutoTransform;
  public static double movementSpeedAutoRotation;
  public static double movementSpeedAutoStrafe;

  public TeleopSwerve(
      Swerve s_Swerve,
      DoubleSupplier translationSup,
      DoubleSupplier strafeSup,
      DoubleSupplier rotationSup,
      BooleanSupplier robotCentricSup) {
    this.s_Swerve = s_Swerve;
    addRequirements(s_Swerve);

    this.translationSup = translationSup;
    this.strafeSup = strafeSup;
    this.rotationSup = rotationSup;
    this.robotCentricSup = robotCentricSup;
  }

  @Override
  public void execute() {
    /* Get Values, Deadband*/
    if(RobotContainer.drivepls) {
      translationVal =
        translationLimiter.calculate(
            MathUtil.applyDeadband(translationSup.getAsDouble(), Constants.Swerve.stickDeadband));
      rotationVal = movementSpeedAutoRotation;
      strafeVal = movementSpeedAutoStrafe;
    } else {
     translationVal =
        translationLimiter.calculate(
            MathUtil.applyDeadband(translationSup.getAsDouble(), Constants.Swerve.stickDeadband));
     strafeVal =
        strafeLimiter.calculate(
            MathUtil.applyDeadband(strafeSup.getAsDouble(), Constants.Swerve.stickDeadband));
     rotationVal =
        rotationLimiter.calculate(
            MathUtil.applyDeadband(rotationSup.getAsDouble(), Constants.Swerve.stickDeadband));
    }
    /* Drive */
    if(RobotContainer.driver.getRawButton(1)) {
      s_Swerve.drive(
        new Translation2d(translationVal, strafeVal).times(Constants.Swerve.maxSpeed * 4),
        -rotationVal * Constants.Swerve.maxAngularVelocity * 4,
        !robotCentricSup.getAsBoolean(),
        true);
    } else if(RobotContainer.driver.getRawButton(2)) {
      s_Swerve.drive(
        new Translation2d(translationVal / 2, strafeVal / 2).times(Constants.Swerve.maxSpeed / 2),
        -rotationVal * Constants.Swerve.maxAngularVelocity / 2,
        !robotCentricSup.getAsBoolean(),
        true);
    }else {
      s_Swerve.drive(
        new Translation2d(translationVal/2, strafeVal/2).times(Constants.Swerve.maxSpeed),
        -rotationVal * Constants.Swerve.maxAngularVelocity,
        !robotCentricSup.getAsBoolean(),
        true);
  }
    }
}