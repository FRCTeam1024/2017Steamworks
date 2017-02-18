package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hopper extends Subsystem {
	public DoubleSolenoid hopper = new DoubleSolenoid(RobotMap.HOPPER_FLAP_PORT_1, RobotMap.HOPPER_FLAP_PORT_2);
	
	public Hopper() {
		
		
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
