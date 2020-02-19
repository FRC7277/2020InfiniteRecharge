/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

/**
 * An example command that uses an example subsystem.
 */
public class JoystickDrive extends CommandBase {
  Joystick joystick = Constants.joystick;

  public JoystickDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drivetrain);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.drivetrain.Turndrive(joystick.getX(),joystick.getY());

    SmartDashboard.putString("Joy X:", Double.toString(this.joy.getX()));
    SmartDashboard.putString("Joy Y:", Double.toString(this.joy.getY()));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drivetrain.Turndrive(joystick.getX(),joystick.getY());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() { 
    return false;
  }
}
