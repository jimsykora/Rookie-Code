package org.usfirst.frc.team2839.robot.commands;

import org.usfirst.frc.team2839.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {

    public DriveDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetEncoderCount();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.setSpeed(.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(Robot.drivetrain.getEncoderCount()) >= 10000);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
