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
import frc.robot.RobotContainer;

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
    //driving the drivetrain through its drivestick
    RobotContainer.drivetrain.turndrive(joystick.getY(),joystick.getZ());
    //letting us know that this is running 
    SmartDashboard.putString("JoystickDrive:","running");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //letting us know that this command has been canceled
    SmartDashboard.putString("JoystickDrive:","stopped");
    //setting the motors power to 0 so it wont keep on going because that would be bad
    RobotContainer.drivetrain.turndrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() { 
    return false;
  }
}
