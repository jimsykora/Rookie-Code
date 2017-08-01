package org.usfirst.frc.team2839.robot.commands;

import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinnerStart extends Command {
	double speed = 0.0;

    public SpinnerStart(double rpm) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.spinnerPID);
    	speed = rpm;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.spinnerPID.setSetpoint(speed);
    	Robot.spinnerPID.setRawTolerance(RobotPreferences.spinTolerance());
    	Robot.spinnerPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.setSpeed(speed);
    	Robot.spinnerPID.getOutput();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
