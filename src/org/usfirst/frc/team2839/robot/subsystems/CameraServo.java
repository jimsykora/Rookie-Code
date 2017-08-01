package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.RobotMap;
import org.usfirst.frc.team2839.robot.commands.CameraHorizontalRotate;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraServo extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Servo verticalservo = null;
	Servo horizontalservo = null;
	
	public CameraServo() {
		super();
		verticalservo = new Servo(RobotMap.CAMERA_VERTICAL_SERVO);
		horizontalservo = new Servo(RobotMap.CAMERA_HORIZONTAL_SERVO);
	}
	
	public void setVerticalAngle(double angle) {
		verticalservo.setAngle(angle);
	}
	
	public void setHorizontalAngle(double angle) {
		horizontalservo.setAngle(angle);
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CameraHorizontalRotate());
    }
}



