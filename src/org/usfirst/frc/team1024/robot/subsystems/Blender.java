package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.Subsystem;

import com.ctre.CANTalon;


import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *Change Log
 * 1/28/2017: Added the blend and stop functions
 * 1/30/2017: added javadocs
 */
public class Blender implements Subsystem {
	public final CANTalon blenderMotor = new CANTalon(RobotMap.BLENDER_PORT);
	
	public Blender() {
		LiveWindow.addActuator("Blender", "Blender Motor", blenderMotor);
	}
	
	/**
	 * Sets the power of the blender motor
	 * @param power
	 */
	public void blend(double power) {
		blenderMotor.set(power);
	}
	
	/**
	 * Stops the blender
	 */
	public void stop() {
		blenderMotor.set(0.0);
	}

	@Override
	public void outputToSmartDashboard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetSensors() {
		// TODO Auto-generated method stub
		
	}
}

