
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.Joystickdrive;

import frc.robot.Robot;
import frc.robot.Constants;
import frc.robot.RobotContainer;


public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private WPI_TalonSRX leftmotor;
  private WPI_TalonSRX rightmotor;
  private DifferentialDrive diffdrive;
  private Joystick joy;


  public Drivetrain(int left, int right, Joystick joy) {
      this.leftmotor=new WPI_TalonSRX(left);
      this.rightmotor=new WPI_TalonSRX(right);
      this.diffdrive = new DifferentialDrive(leftmotor, rightmotor);
      this.joy=joy;
  }
  public Drivetrain(){
    this(Constants.leftmotor, Constants.rightmotor, Robot.robotcontainer.getJoystick());
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new Joystickdrive(this.joy));
  }
  public DifferentialDrive getDrive() {
    return this.diffdrive;
  }
  public void Tankdrive(Joystick joy){
    double turn=joy.getX()/5;
    double speed=joy.getY();
    double leftspeed=speed+turn;
    double rightspeed=speed-turn;
    diffdrive.tankDrive(leftspeed, rightspeed);
  }

}