package org.usfirst.frc.team2839.robot.commands;

import org.usfirst.frc.team2839.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ShooterHoodDeploy extends InstantCommand {// use instant command for pneumatics

    public ShooterHoodDeploy() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (Robot.shooter);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.shooter.deploy();
    }

}
