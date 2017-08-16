
package org.usfirst.frc.team2839.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2839.robot.commands.*; //* is a wild card
import org.usfirst.frc.team2839.robot.subsystems.*; //* is a wild card
import org.usfirst.frc.team2839.robot.subsystems.CameraServo;

/**
 * A VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {  //the Robot class is the only place that knows about all subsystems

	//Test comment
	public static  ExampleSubsystem exampleSubsystem; // ExampleSubsystem is equiv to a directory path 		& exampleSubsystem is the name of thar directory
	public static  Drivetrain drivetrain;  //Drivetrain was System, new Drivetrain() was null
	public static  Shooter shooter;
	public static ShooterPID shooterPID;
	public static  Turret turret;
	public static TurretPID turretPID;
	public static  NavXMicro navXMicro;
	public static Vision vision;
	public static CameraServo cameraServo;
	
	public static Dashboard dashboard; //Smart Dashboard & OI must be at the end
	public static OI oi; //Smart Dashboard & OI must be at the end

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		exampleSubsystem = new ExampleSubsystem();
		drivetrain = new Drivetrain();
		shooter = new Shooter();
		shooterPID = new ShooterPID();
		turret = new Turret();
		turretPID = new TurretPID();
		navXMicro = new NavXMicro();
		vision = new Vision();
		cameraServo = new CameraServo();
		
		chooser.addDefault("Default Auto", new AutonomousCommand());    /////////////
		//chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		dashboard  = new Dashboard(); //Smart Dashboard & OI must be at the end
		
		// OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
		oi = new OI(); //Smart Dashboard & OI must be at the end
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		dashboard.update();  //makes SmartDashboard live when in disabled mode
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		dashboard.update();  //makes SmartDashboard live when in disabled mode
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
