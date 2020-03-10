
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Lift extends SubsystemBase {
    private VictorSPX motorL;
    private VictorSPX motorR;
    public Lift(int leftMotor, int rightMotor){
        motorL=new VictorSPX(leftMotor);
        motorR=new VictorSPX(rightMotor);
    }
    public Lift(){
        this(Constants.liftMotorPortL, Constants.liftMotorPortR);
    }
    
    public void move(double speed){
        motorR.set(ControlMode.PercentOutput,speed);
        motorL.set(ControlMode.PercentOutput,-speed); 
        SmartDashboard.putNumber("rightLiftPower", speed); 
        SmartDashboard.putNumber("leftLiftPower", -speed); 

    } 
    public void moveLeft(double speed){
        motorL.set(ControlMode.PercentOutput,speed);
        SmartDashboard.putNumber("leftLiftPower", -speed);   
    } 
    public void moveRight(double speed){
        motorR.set(ControlMode.PercentOutput,-speed);
        SmartDashboard.putNumber("rightLiftPower", speed); 
    } 
}