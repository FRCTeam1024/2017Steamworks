package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.Subsystem;

import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 */
public class Gear implements Subsystem {
	public Solenoid pusher = new Solenoid(RobotMap.GEAR_PUSHER_PORT);
	public Solenoid clamp = new Solenoid(RobotMap.GEAR_CLAMP_PORT);
	
	public void clamp(boolean close) {
		clamp.set(close);
	}
	
	public void push(boolean push) {
		pusher.set(push);
	}
	
	@Override
	public void outputToSmartDashboard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetSensors() {
		// TODO Auto-generated method stub
		
	}

}

