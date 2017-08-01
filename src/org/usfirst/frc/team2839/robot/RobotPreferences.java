package org.usfirst.frc.team2839.robot;

import edu.wpi.first.wpilibj.Preferences;

//this class was created by right clicking on the red underlined RobotPreferences and putting it under "...2839,robot"

public class RobotPreferences {  
	//for driving PID
	public static double spinP() {
		return Preferences.getInstance().getDouble("spinP", 0.05);  //add to subsystem PID: "enable method"
	}
	public static double spinI() {
		return Preferences.getInstance().getDouble("spinI", 0.0);
	}
	public static double spinD() {
		return Preferences.getInstance().getDouble("spinD", 0.1);
	}
	public static double spinF() {
		return Preferences.getInstance().getDouble("spinF", 0.0);
	}
	public static double spinMaxSpeed() {
		return Preferences.getInstance().getDouble("spinMaxSpeed", 0.7);
	}
	public static double spinTolerance() {
		return Preferences.getInstance().getDouble("spinTolerance", 5.0);
	}
	public static double targetRate() {
		return Preferences.getInstance().getDouble("targetRate", 5.0);
	}
}
