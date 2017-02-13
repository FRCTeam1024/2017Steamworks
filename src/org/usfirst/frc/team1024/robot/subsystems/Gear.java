package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.Subsystem1024;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gear extends Subsystem implements Subsystem1024 {
	public Solenoid pusher = new Solenoid(RobotMap.GEAR_PUSHER_PORT_1);
	public DoubleSolenoid clamper = new DoubleSolenoid(RobotMap.GEAR_CLAMP_PORT_1, RobotMap.GEAR_CLAMP_PORT_2);
	
	public void clamp(int clamp) {
		if (clamp == 1) {
			clamper.set(Value.kForward);
		} else if (clamp == -1) {
			clamper.set(Value.kReverse);
		} else if (clamp == 0) {
			clamper.set(Value.kOff);
		}
	}
	
	public void push(boolean push) {
		if (push == true) {
			pusher.set(true/*Value.kForward*/);
		} else if (push == false) {
			pusher.set(false/*Value.kReverse*/);
		}
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

