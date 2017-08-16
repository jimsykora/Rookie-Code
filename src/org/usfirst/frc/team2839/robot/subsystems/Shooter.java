package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.RobotMap;
import org.usfirst.frc.team2839.robot.commands.DeployUsingSwitchCommandGroup;
import org.usfirst.frc.team2839.robot.commands.JoystickShooter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem { //contains only variables and methods

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP shootMotor = null;  //added, see Tayer's Power Point document, these are empty variables
	Solenoid sol1 = null;// variable created here so that it can be used by any method in this class
	Solenoid sol2 = null; // DoubleSolenoid if using a double solenoid
	DigitalInput LS1 = null;
	DigitalInput LS2 = null;
	Encoder QEncoder = null;
	public Shooter(){//added this constructor
		shootMotor = new VictorSP(RobotMap.SHOOTMOTOR);//must create a constant in RobotMap
		shootMotor.setSafetyEnabled(false);//to allow a motor to run continuously without continuous repeated commands
		sol1 = new Solenoid (RobotMap.SHOOTER_SOL1);//must create a constant in RobotMap
		sol2 = new Solenoid (RobotMap.SHOOTER_SOL2);//must create a constant in RobotMap
		LS1 = new DigitalInput(RobotMap.SHOOTER_HOOD_UP_SWTICH);//must create a constant in RobotMap
		LS2 = new DigitalInput(RobotMap.SHOOTER_HOOD_DOWN_SWTICH);//must create a constant in RobotMap
		QEncoder = new Encoder(RobotMap.RR_ENCODER_CH_A,RobotMap.RR_ENCODER_CH_B);
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
		shootMotor.set(speed);
	}
	public void resetEncoderCount(){
		QEncoder.reset();
	}
	public double getEncoderCount(){//this method returns somrthing so we define it as double, if void it would not return anything
		return QEncoder.get();
	}
	public double getEncoderRate(){//this method returns somrthing so we define it as double, if void it would not return anything
		return QEncoder.getRate();
	}
	public double getEncoderRPS(){//rps is getERate/(100 counts/rev) //getERate is counts/sec
		
		double cpr = 100.0*5.5; //cpr of shooter wheel (encoder counts/rev)*(gear reduction)
		return QEncoder.getRate()/cpr;  //returns rps (rev/sec) of shooter wheel
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new JoystickShooter()); //starts this coommand running until another command requires this subsystem 
    }
}

