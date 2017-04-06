package org.usfirst.frc.team1024.robot.util;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.CANSpeedController;

public class KilaTalon extends CANTalon implements CANSpeedController{

	public KilaTalon(int deviceNumber) {
		super(deviceNumber);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets the encoders distance in inches
	 * Note: This constant is the: tickrate/gear ratio * wheel circumference
	 * @returns Encoder distance traveled (inches)
	 */
	
	public double getDistanceInInches() {
		return (getEncPosition() * Constants.WHEEL_CIRCUMFERENCE) / Constants.ENCOER_TICKS_PER_WHEEL_REV;
		
	}
	
	public void goDistanceInInches(double distance) {
		changeControlMode(TalonControlMode.Position);
		set((distance / 3) / Constants.WHEEL_CIRCUMFERENCE);
		enable();
	}
}
