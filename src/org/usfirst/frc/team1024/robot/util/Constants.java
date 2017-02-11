package org.usfirst.frc.team1024.robot.util;

public class Constants {
	public static final double WHEEL_RADIUS = 3.125;
	public static final double WHEEL_CIRCUMFERENCE = 19.6349540849; //2 * Math.PI * WHEEL_RADIUS
	public static final double ENCODER_CONSTANT_INCHES = 6.11154981474; //360 		  / (3			* 19.6349540849) 
																		//(ticks/rev) / (gear ratio * wheel circumference)
	public static double initShooterPower = 0.0; //preset shooter power
}