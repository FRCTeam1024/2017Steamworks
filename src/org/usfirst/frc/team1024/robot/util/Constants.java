package org.usfirst.frc.team1024.robot.util;

public class Constants {
	public static final double INIT_SHOOTER_POWER = 2000.0; //preset shooter power
	public static final double MAX_SHOOTER_SPEED = 2900.0;
	//Field Constants:
	public static final double DISTANCE_TO_BASELINE = 93.25; //distance to baseline from alliance station wall in inches
	//Robot Constants:
	public static final double ROBOT_WIDTH = 0.0; //measured from left to right
	public static final double ROBOT_LENGTH = 0.0; //measured from front to back
	
	public static final double WHEEL_RADIUS = 3.125;
	public static final double WHEEL_CIRCUMFERENCE = 19.6349540849; //2 * Math.PI * WHEEL_RADIUS
	public static final double ENCODER_CONSTANT_INCHES = 6.11154981474; //360 		  / (3			* 19.6349540849) 
																		//(ticks/rev) / (gear ratio * wheel circumference)
	//PID CONSTANTS vvv
	public static final double SHOOTER_kU = 0.6; //number found when tuning for stead oscillations
	//public static final double SHOOTER_kP = 0.198; //for some overshoot
	public static final double SHOOTER_kP = 0.12; //for no overshoot
	public static final double SHOOTER_kI = 0.0005; 
	public static final double SHOOTER_kD = 0.0003;
	public static final double SHOOTER_kF = 0.1724137931034483;
	
}