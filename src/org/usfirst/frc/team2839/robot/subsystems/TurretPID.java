package org.usfirst.frc.team2839.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.RobotMap;
import org.usfirst.frc.team2839.robot.RobotPreferences;
import org.usfirst.frc.team2839.robot.commands.TurretStart;

/**
 *
 */
public class TurretPID extends PIDSubsystem {
	double output = Robot.turret.turretEncoder.getAverageVoltage()-RobotMap.OFFSET_TURRET;
	boolean outputValid = false;
	double targetAngle = 2.5;  //remove later if/when PID loop gets tuned properly. its used to delay turning off PID loop while in motion
	double tolerance = 0.1;

    // Initialize your subsystem here
    public TurretPID() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("TurretPID",0,0,0);
    	this.setSetpoint(0.0);
    	getPIDController().setContinuous(true);
    }
    
    public void enable()  {
    	this.getPIDController().setPID(RobotPreferences.turretP(), RobotPreferences.turretI(), RobotPreferences.turretD());
    	double maxSpeed = RobotPreferences.turretMaxSpeed(); //set to <1.0 to limit max motor speed
    	this.setOutputRange(-maxSpeed, maxSpeed);
    	this.setInputRange(0.0, 5.0);
    	outputValid = false;
    	super.enable();
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        //return Robot.turret.getPotAngle();
        return Robot.turret.turretEncoder.getAverageVoltage()-RobotMap.OFFSET_TURRET;//2.5 is the joystick signal when pushed forward
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	this.output = output;
    	outputValid = true;

    }
    public double getOutput() {
    	if(this.getPIDController().isEnabled() == false || outputValid == false) { // == meams "is equal to", || means "or"
    		return 0.0;
    	}
    	return output;
    }
    public void setRawTolerance(double tolerance) {
    	this.tolerance = tolerance;
    }
    /*public boolean onRawTargrt() {   //use when having pre set turret positions
    	if(Math.abs(getPIDController().getSetpoint() - Robot.shooter.getEncoderRPS()) < tolerance) {
    		targetAngle = targetAngle +1;
    	}
    	else {
    		targetAngle = 0;
    	}
    	//return (targetAngle >= RobotPreferences.targetRate());
    	return (targetAngle >= 0.3);
    }*/

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
