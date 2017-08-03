package org.usfirst.frc.team2839.robot;

import org.usfirst.frc.team2839.robot.commands.CameraDown;
import org.usfirst.frc.team2839.robot.commands.CameraLeft;
import org.usfirst.frc.team2839.robot.commands.CameraRight;
import org.usfirst.frc.team2839.robot.commands.CameraUp;
import org.usfirst.frc.team2839.robot.commands.ShooterStart;
import org.usfirst.frc.team2839.robot.commands.ShooterStop;
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
	public Joystick driverStick = new Joystick(RobotMap.OI_DRIVESTICK);  //added, need to import
	public Joystick joystick = new Joystick(RobotMap.OI_JOYSTICK);  //added, need to import
	Button D1 = new JoystickButton(driverStick, 1); //added, need to import
	Button D8 = new JoystickButton(driverStick, 8); //added for using Xbox gamepad
	Button D4 = new JoystickButton(driverStick, 4); //added for using Xbox gamepad
	Button D2 = new JoystickButton(driverStick, 2); //added for using Xbox gamepad
	Button D11 = new JoystickButton(driverStick, 11); //added, need to import
	Button D5 = new JoystickButton(driverStick, 5); 
	Button D6 = new JoystickButton(driverStick, 6); 
	Button D3 = new JoystickButton(driverStick, 3); //added, need to import      //////////
	Button D7 = new JoystickButton(driverStick, 7);
	Button J1 = new JoystickButton(joystick, 1);

	
	public OI(){							//added
		D1.whenPressed(new DriveForward());  //added
		D1.whenReleased(new DriveStop());  //added
		D8.whileHeld(new DriveTank());
		D4.whenPressed(new ShooterHoodDeploy());
		D2.whenPressed(new ShooterHoodRetract());
		D11.whenPressed(new MotorStartStop());
		D5.whenPressed(new CameraUp());
		D5.whenReleased(new CameraDown());
		D6.whenPressed(new CameraLeft());
		D6.whenReleased(new CameraRight());
		D3.whenPressed(new ShooterStart(RobotPreferences.spinSlow()));
		D3.whenReleased(new ShooterStop());
		//J1.whileHeld(new JoystickShooter());
		//J1.whenReleased(new ShooterStart());
	}
}
