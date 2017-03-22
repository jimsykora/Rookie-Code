package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.commands.DashboardUpdate;
import org.usfirst.frc.team2839.robot.commands.ShooterDeploy;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Dashboard extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Dashboard(){
						//pushing this button on the Smart Dashboard will activate this command
		SmartDashboard.putData("Deploy Shooter",new ShooterDeploy());  //use new to create a new instance
	}
	
	public void update() {
		SmartDashboard.putBoolean("Is limit switch closed?", Robot.shooter.isLS1Closed());
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DashboardUpdate());
    }
}

