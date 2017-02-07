package org.usfirst.frc.team1024.robot;
/**
 * @author team1024
 * Change Log:
 * 1/26/17: Added drive motors
 * 2/1/17: Removed middle motors
 */
public class RobotMap {
	//Motors
		//Drivetrain
		public static final int FRONT_LEFT_DRIVETRAIN_PORT = 0;
		public static final int REAR_LEFT_DRIVETRAIN_PORT = 1;
		public static final int FRONT_RIGHT_DRIVETRAIN_PORT = 2;
		public static final int REAR_RIGHT_DRIVETRAIN_PORT = 3;
		//Shooter
		public static final int SHOOTER_PORT = 6;
		//Climber
		public static final int LEFT_CLIMBER_PORT = 7;
		public static final int RIGHT_CLIMBER_PORT = 8;
		//Blender
		public static final int BLENDER_PORT = 9;
	//Pneumatics
		public static final int DRIVETRAIN_SHIFTER_PORT = 0;
		public static final int GEAR_PUSHER_PORT = 1;
		public static final int GEAR_CLAMP_PORT = 2;
		
	//Analog Sensors
		public static final int GYRO_PORT = 0;
		
		
	//Digital Sensors
		//Drivetrain
		public static final int ULTRASONIC_PORT = 0;
		//Shooter
		public static final int SHOOTER_ENCODER_PORT_A = 1;
		public static final int SHOOTER_ENCODER_PORT_B = 2;
	//Controls
		public static final int LOGITECH_PORT = 0;
		public static final int LEFT_JOYSTICK_PORT = 1;
		public static final int RIGHT_JOYSTICK_PORT = 2;
}
