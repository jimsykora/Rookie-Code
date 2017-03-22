package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.RobotMap;
import org.usfirst.frc.team2839.robot.commands.DeployUsingSwitchCommandGroup;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem { //contains only variables and methods

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP LRmotor = null;		//added, see Tayer's Power Point document, these are empty variables
	VictorSP RRmotor = null;
	Solenoid sol1 = null;// variable created here so that it can be used by any method in this class
	Solenoid sol2 = null; // DoubleSolenoid if using a double solenoid
	DigitalInput LS1 = null;
	DigitalInput LS2 = null;
	public Shooter(){//added this constructor
		LRmotor = new VictorSP(RobotMap.SHOOTMOTOR_L);//must create a constant in RobotMap
		RRmotor = new VictorSP(RobotMap.SHOOTMOTOR_R);//must create a constant in RobotMap
		LRmotor.setSafetyEnabled(false);//to allow a motor to run continuously without continuous repeated commands
		RRmotor.setSafetyEnabled(false);//to allow a motor to run continuously without continuous repeated commands
		sol1 = new Solenoid (RobotMap.SHOOTER_SOL1);//must create a constant in RobotMap
		sol2 = new Solenoid (RobotMap.SHOOTER_SOL2);//must create a constant in RobotMap
		LS1 = new DigitalInput(RobotMap.SHOOTER_START_SWTICH);//must create a constant in RobotMap
		LS2 = new DigitalInput(RobotMap.SHOOTER_STOP_SWTICH);//must create a constant in RobotMap
	}
	public boolean isLS1Closed(){
		return (LS1.get() == false); //or return LS1.get() ; depending on wiring of LS normally open or normally closed
		}
	public boolean isLS2Closed(){
		return (LS2.get() == false); //or return LS2.get() ; depending on wiring of LS normally open or normally closed
	}
	public void deploy(){
		sol1.set(true);//(Value.kForward) for double solenoids
		sol2.set(true);//(Value.kForward) for double solenoids
	}
	public void retract(){
		sol1.set(false);//(Value.kForward) for double solenoids
		sol2.set(false);//(Value.kForward) for double solenoids
	}
	public void setSpeed(double speed){
		LRmotor.set(speed);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DeployUsingSwitchCommandGroup()); //starts this coommand running until another command requires this subsystem 
    }
}

