package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.RobotMap;
import org.usfirst.frc.team2839.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP LFmotor = null;		//added, see Tayer's Power Point document, these are empty variables
	VictorSP RFmotor = null;
	VictorSP RRmotor = null;
	VictorSP LRmotor = null;
	RobotDrive robotDrive = null;  //added
	public Drivetrain(){			//added this constructor
		LFmotor = new VictorSP(RobotMap.DRIVETRAIN_LF_MOTOR);//instantiate here
		RFmotor = new VictorSP(RobotMap.DRIVETRAIN_RF_MOTOR);
		RRmotor = new VictorSP(RobotMap.DRIVETRAIN_RR_MOTOR);
		LRmotor = new VictorSP(RobotMap.DRIVETRAIN_LR_MOTOR);
		robotDrive = new RobotDrive(LFmotor, LRmotor, RFmotor, RRmotor); // must be in this order,LF,LR, RF, RR
	}

	public void setSpeed(double speed){  //this is a method, it describes what a robot can do but not telling it to do it (a method in DriveForward
		LFmotor.set(speed);
		RFmotor.set(speed);
		RRmotor.set(-speed);// motors on each side go in different directions
		LRmotor.set(-speed);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed){ // creates the variable moveSpeed
		robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
	}
	
	public void tankDrive(double leftSpeed, double rightSpeed){ // creates the variable moveSpeed
		robotDrive.tankDrive(leftSpeed, rightSpeed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveArcade());  //added
    }
}

