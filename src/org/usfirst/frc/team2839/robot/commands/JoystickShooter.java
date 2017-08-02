package org.usfirst.frc.team2839.robot.commands;

import org.usfirst.frc.team2839.robot.OI;
import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickShooter extends Command {
	double speed = 0.0;

    public JoystickShooter() {  //rps is rev/sec
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooterPID);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooterPID.setRawTolerance(RobotPreferences.spinTolerance());
    	Robot.shooterPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	speed = Robot.oi.joystick.getY()*100.0*(16.0/44.0); // counts/rev of encoder*gear reduction;
    	Robot.shooterPID.setSetpoint(speed);
    	Robot.shooter.setSpeed(Robot.shooterPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooterPID.disable();
    	Robot.shooter.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
