package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.Subsystem1024;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gear extends Subsystem implements Subsystem1024 {
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

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}

