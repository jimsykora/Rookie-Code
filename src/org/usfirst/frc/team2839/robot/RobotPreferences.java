package org.usfirst.frc.team2839.robot;

import edu.wpi.first.wpilibj.Preferences;

//this class was created by right clicking on the red underlined RobotPreferences and putting it under "...2839,robot"

public class RobotPreferences {  
	//for driving PID
	public static double spinP() {
		return Preferences.getInstance().getDouble("spinP", 0.1);  //add to subsystem PID: "enable method"
	}
	public static double spinI() {
		return Preferences.getInstance().getDouble("spinI", 0.04);
	}
	public static double spinD() {
		return Preferences.getInstance().getDouble("spinD", 0.0);
	}
	public static double spinF() {
		return Preferences.getInstance().getDouble("spinF", 0.0); //works best at 0.0
	}
	public static double spinMaxSpeed() {
		return Preferences.getInstance().getDouble("spinMaxSpeed", 0.8);
	}
	public static double spinTolerance() {
		return Preferences.getInstance().getDouble("spinTolerance", 2.0);
	}
	public static double targetRate() {
		return Preferences.getInstance().getDouble("targetRate", 5.0);
	}
	public static double spinSlow() {
		return Preferences.getInstance().getDouble("slowSpin", 2);
	}
	public static double spinFast() {
		return Preferences.getInstance().getDouble("fastSpin", 15);
	}
	public static double turretP() {
		return Preferences.getInstance().getDouble("turretP", -1.0);  //add to subsystem PID: "enable method"
	}
	public static double turretI() {
		return Preferences.getInstance().getDouble("turretI", 0.0);
	}
	public static double turretD() {
		return Preferences.getInstance().getDouble("turretD", 0.0);
	}
	public static double turretMaxSpeed() {
		return Preferences.getInstance().getDouble("turretMaxSpeed", 1.0);
	}
}
