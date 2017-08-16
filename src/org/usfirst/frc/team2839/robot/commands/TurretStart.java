package org.usfirst.frc.team2839.robot.commands;

import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.RobotMap;
import org.usfirst.frc.team2839.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurretStart extends Command {
	double angle = 0.0;
	
    public TurretStart(double degrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.turret);
    	requires(Robot.turretPID);
    	angle = degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.turretPID.setAbsoluteTolerance(0.1);//.setRawTolerance(RobotPreferences.spinTolerance());
    	Robot.turretPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle=((5-(Robot.oi.joystick.getThrottle()+1)*2.5)); //if using throttle
    	//angle=((5-(Robot.oi.joystick.getDirectionDegrees()+180)/72));// if using joystick
    	Robot.turretPID.setSetpoint(angle);
    	Robot.turret.setAngle(Robot.turretPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {   //is this needed? don't you always want to be controlling the angle?
    	Robot.turretPID.disable();	//will temporarily disable PID loop if eg over ridden by a button location command 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
