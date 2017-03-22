package org.usfirst.frc.team2839.robot.commands;

import org.usfirst.frc.team2839.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedTurn extends TimedCommand {
	private boolean m_turnRight;  //this is a global variable
	private double rotateSpeed;

    public TimedTurn(double timeout, boolean turnRight) { // must save turnRight as a global variable as shown above
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (Robot.drivetrain); //import org.usfirst.frc.team2839.robot.Robot not java.sre, will have error until added to Robot 									class
        m_turnRight = turnRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	rotateSpeed = 0.2;
    	if (m_turnRight == true){  //== is used to compare values, = is to set values, "if (m_turnRight){" does the same thing
    		rotateSpeed = rotateSpeed*-1;
    	}    	//{} can be eliminated for one line IF statements
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.drivetrain.arcadeDrive(0, rotateSpeed);
    }

    // Called once after timeout
    protected void end() {
    	Robot.drivetrain.setSpeed(0.0); //added this method, it could be here or in initialize
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
