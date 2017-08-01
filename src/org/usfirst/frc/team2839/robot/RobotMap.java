package org.usfirst.frc.team2839.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	public static final int DRIVETRAIN_LF_MOTOR = 0;  //added
	public static final int DRIVETRAIN_RF_MOTOR = 4;
	public static final int DRIVETRAIN_RR_MOTOR = 7;
	public static final int DRIVETRAIN_LR_MOTOR = 3;
	public static final int OI_JOYSTICK = 2;
	public static final int JOYSTICK_ROTATE_AXIS = 2;//created by correcting error in DriveArcade
	public static final int JOYSTICK_MOVE_AXIS = 1; //value is determined by looking at joystick
	public static final int JOYSTICK_LEFT_AXIS = 1;
	public static final int JOYSTICK_RIGHT_AXIS = 3;
	public static final int SHOOTMOTOR_L = 2;  //added
	public static final int SHOOTMOTOR_R = 6;
	public static final int SHOOTER_SOL1 = 0;
	public static final int SHOOTER_SOL2 = 1;
	public static final int SHOOTER_START_SWTICH =8 ;
	public static final int SHOOTER_STOP_SWTICH = 9;
	public static final int IR_DISTANCE_SENSOR = 6;
	public static final int QUAD_ENCODER_CH_A = 6;
	public static final int QUAD_ENCODER_CH_B = 7;
	public static final int CAMERA_HORIZONTAL_SERVO = 8;
	public static final int CAMERA_VERTICAL_SERVO = 9;
	

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
