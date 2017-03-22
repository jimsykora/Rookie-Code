package org.usfirst.frc.team2839.robot.commands;

import org.usfirst.frc.team2839.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {  

    public DriveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.drivetrain); //import org.usfirst.frc.team2839.robot.Robot not java.sre, will have error until added to Robot 									class
    }

    // Called just before this Command runs the first time 
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.setSpeed(0.2); //added this method
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
