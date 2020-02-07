
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


public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private WPI_TalonSRX leftmotor, rightmotor;
  private DifferentialDrive diffdrive;

  public Drivetrain(int left, int right) {
      this.leftmotor=new WPI_TalonSRX(left);
      this.rightmotor=new WPI_TalonSRX(right);
      this.diffdrive = new DifferentialDrive(leftmotor, rightmotor);
  }
  public Drivetrain(){
    this(Constants.leftmotor, Constants.rightmotor);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public DifferentialDrive getDrive() {
    return this.diffdrive;
  }
  public void Tankdrive(double leftPower, double rightPower){
    diffdrive.tankDrive(leftPower, rightPower);
  }
  public void Turndrive(double speed, double turn){
    double leftPower=speed+turn;
    double rightPower=speed-turn;
    diffdrive.tankDrive(leftPower, rightPower);
  }

}