package org.usfirst.frc.team2839.robot.commands;

import org.usfirst.frc.team2839.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinnerStop extends Command {
	double speed = 0.0;

    public SpinnerStop(double rpm) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.spinnerPID);
    	speed = rpm;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.spinnerPID.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.spinnerPID.disable();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}