package org.usfirst.frc.team1024.robot.util;

import com.ctre.CANTalon;

public class KilaTalon extends CANTalon{

	public KilaTalon(int deviceNumber) {
		super(deviceNumber);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets the encoders distance in inches
	 * Note: This constant is the: tickrate/gear ratio * wheel circumference
	 * @returns Encoder distance traveled (inches)
	 */
	public double getDistance() {
		return getEncPosition() / Constants.ENCODER_CONSTANT_INCHES;
	}
}
