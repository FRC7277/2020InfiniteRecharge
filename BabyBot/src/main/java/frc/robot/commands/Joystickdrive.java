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
  Button turboButton= new Button(12), flipButton=new Button(11);
  boolean turbo=false;

  public JoystickDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveTrain);
    addRequirements(RobotContainer.lift);
  }
  private void movelift(){
    if(joystick.getRawButton(5)||joystick.getRawButton(6)){
      RobotContainer.lift.move(0.5);
      
    }else if(joystick.getRawButton(3)||joystick.getRawButton(4)){ 
      RobotContainer.lift.move(-0.5);
    }
    else{
      RobotContainer.lift.move(0);
    }   
  }
  //start of overriden commands from command base
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //driving the drivetrain through its drivestick
    if(turbo){
      RobotContainer.driveTrain.turnDrive(joystick.getY(),joystick.getZ());
    }
    else{
      RobotContainer.driveTrain.turnDrive(joystick.getY(),joystick.getZ()/1.75);
    }
    SmartDashboard.putString("drive mode", "turn drive");
    SmartDashboard.putNumber("joystick y", joystick.getY());
    SmartDashboard.putNumber("joystick z", joystick.getZ());
    SmartDashboard.putBoolean("speedy mode", turbo);
    movelift();

    if(turboButton.pushed()){
      turbo = !turbo;
    }
    
    if(flipButton.pushed()){
      RobotContainer.driveTrain.flip();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //setting the motors power to 0 so it wont keep on going because that would be bad
    RobotContainer.driveTrain.turnDrive(0,0);
    RobotContainer.lift.move(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() { 
    return false;
  }
}
