package org.usfirst.frc.team2839.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DeployUsingSwitchCommandGroup extends CommandGroup {

    public DeployUsingSwitchCommandGroup() {//very useful for Autonomous, Limit Switches & button presses
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new DetectShooterSwitch1()); //() for all commands since arguments may be needed
    	addSequential(new ShooterDeploy()); 
    	addSequential(new MotorStartStop());
    	addSequential(new DetectShooterSwitch2()); //() for all commands since arguments may be needed
    	addSequential(new ShooterRetract());
    }
}
