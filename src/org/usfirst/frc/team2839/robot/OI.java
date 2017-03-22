package org.usfirst.frc.team2839.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2839.robot.commands.*; //was Drivetrain, change to * to import all commands

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public Joystick stick = new Joystick(RobotMap.OI_JOYSTICK);  //added, need to import
	Button J1 = new JoystickButton(stick, 1); //added, need to import
	Button J8 = new JoystickButton(stick, 8); //added for using Xbox gamepad
	Button J4 = new JoystickButton(stick, 4); //added for using Xbox gamepad
	Button J2 = new JoystickButton(stick, 2); //added for using Xbox gamepad
	Button J11 = new JoystickButton(stick, 11); //added, need to import
	Button J5 = new JoystickButton(stick,5); 
	Button J6 = new JoystickButton(stick, 6); 
	Button J3 = new JoystickButton(stick, 3); //added, need to import      //////////
	
	public OI(){							//added
		J1.whenPressed(new DriveForward());  //added
		J1.whenReleased(new DriveStop());  //added
		J8.whileHeld(new DriveTank());
		J4.whenPressed(new ShooterDeploy());
		J2.whenPressed(new ShooterRetract());
		J11.whenPressed(new MotorStartStop());
		J5.whenPressed(new RearCameraOn());
		J6.whenPressed(new FwdCameraOn());
	}
}
