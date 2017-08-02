package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.RobotPreferences;
import org.usfirst.frc.team2839.robot.commands.*;

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
		SmartDashboard.putData("Deploy Shooter",new ShooterHoodDeploy());  //use new to create a new instance
		SmartDashboard.putData("Reset Yaw",new ResetYaw());
		SmartDashboard.putData("Reset X",new ResetX());
		SmartDashboard.putData("Spin Slow",new ShooterStart(RobotPreferences.spinSlow()));
		SmartDashboard.putData("Spin Fast",new ShooterStart(RobotPreferences.spinFast()));
		SmartDashboard.putData("Stop Spinner",new ShooterStop());
	}
	
	public void update() {
		SmartDashboard.putBoolean("Is limit switch closed?", Robot.shooter.isLS1Closed());
		SmartDashboard.putNumber("IRVoltage", Robot.drivetrain.getIRSensorVoltage());
		SmartDashboard.putNumber("IRAvgVoltage", Robot.drivetrain.getIRSensorAverageVoltage());
		SmartDashboard.putNumber("Encoder Count", Robot.shooter.getEncoderCount());
		SmartDashboard.putNumber("Encoder Rate", Robot.shooter.getEncoderRate());
		SmartDashboard.putNumber("Encoder RPS", Robot.shooter.getEncoderRPS());
		SmartDashboard.putNumber("Joystick throttle", Robot.oi.driverStick.getThrottle());
		SmartDashboard.putNumber("NavX yaw", Robot.navXMicro.getYaw());
		SmartDashboard.putNumber("NavX pitch", Robot.navXMicro.getPitch());
		SmartDashboard.putNumber("NavX roll", Robot.navXMicro.getRoll());
		SmartDashboard.putNumber("NavX x distance", Robot.navXMicro.getDisplacementX());
		SmartDashboard.putNumber("NavX x gyro", Robot.navXMicro.getRawGyroX());
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

