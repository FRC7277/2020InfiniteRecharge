
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DMC60;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Lift extends SubsystemBase {
    private DMC60 motorL;
    private DMC60 motorR;
    public Lift(int leftMotor, int rightMotor){
        motorL=new DMC60(leftMotor);
        motorR=new DMC60(rightMotor);
    }
    public Lift(){
        this(Constants.liftMotorPortL, Constants.liftMotorPortR);
    }
    private void updateDashBoard(){
        SmartDashboard.putNumber("leftLiftPosition:", motorL.getPosition());
        SmartDashboard.putNumber("rightLiftPosition:", motorR.getPosition());
    }
    public void move(int speed){
        motorR.set(speed);
        motorL.set(speed);
        updateDashBoard();
        
    }
    public void setPosition(double position){
        motorR.setPosition(position);
        motorL.setPosition(position);
        updateDashBoard();
    }
}