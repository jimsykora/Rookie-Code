package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.RobotMap;
import org.usfirst.frc.team2839.robot.commands.TurretStart;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Turret extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP turretMotor = null;
	AnalogInput turretEncoder= null;
	
	public Turret(){//added this constructor
		turretMotor = new VictorSP(RobotMap.TURRETMOTOR);
		turretMotor.setSafetyEnabled(false);//to allow a motor to run continuously without continuous repeated commands
		turretEncoder = new AnalogInput(RobotMap.TURRET_ENCODER);
	}
	public void setAngle(double angle){
		turretMotor.setSpeed(angle);
	}
	public double getPotAngle(){
		return turretEncoder.getAverageVoltage()-RobotMap.OFFSET_TURRET;
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TurretStart(0.0-RobotMap.OFFSET_TURRET));
    }
}

