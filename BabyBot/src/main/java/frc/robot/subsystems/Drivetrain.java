
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.JoystickDrive;


public class Drivetrain extends SubsystemBase {
  //creating motors
  private WPI_TalonSRX leftmotor, rightmotor;
  private DifferentialDrive diffdrive;

  public Drivetrain(int left, int right) {
      this.leftmotor=new WPI_TalonSRX(left);
      this.rightmotor=new WPI_TalonSRX(right);
      this.diffdrive = new DifferentialDrive(leftmotor, rightmotor);
      setDefaultCommand(new JoystickDrive());
  }
  public Drivetrain(){
    this(Constants.leftmotor, Constants.rightmotor);
  }
  
  @Override
  public void periodic() {
    
  }
  public DifferentialDrive getDrive() {
    return this.diffdrive;
  }
  public void tankdrive(double leftPower, double rightPower){
    diffdrive.tankDrive(leftPower, rightPower);
  }
  public void turndrive(double speed, double turn){
    double leftPower=speed+turn;
    double rightPower=speed-turn;
    diffdrive.tankDrive(leftPower, rightPower);
  }

}