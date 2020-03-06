package frc.robot.commands;

import frc.robot.Constants;

public class Button {
    private boolean pushed=false;
    private int port;

    public Button (int port){
        this.port=port;
    }

    public boolean pushed(){
        if(Constants.joystick.getRawButton(port)){
            if(!pushed){
                pushed=true;
                return true;
            }
            pushed=true; 
        }else{
            pushed=false;
        }
        
        return false;
    }

}