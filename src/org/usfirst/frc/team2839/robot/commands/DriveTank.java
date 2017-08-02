package org.usfirst.frc.team2839.robot.commands;

import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTank extends Command {

    public DriveTank() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.drivetrain); //added
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftSpeed = Robot.oi.driverStick.getRawAxis(RobotMap.DRIVESTICK_LEFT_AXIS);  //must create this constant
    	double rightSpeed = Robot.oi.driverStick.getRawAxis(RobotMap.DRIVESTICK_RIGHT_AXIS);
    	Robot.drivetrain.tankDrive(leftSpeed, rightSpeed);	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.tankDrive(0, 0);  //added
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();//added
    }
}
