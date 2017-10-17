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
	
		public static final int FRONT_LEFT_DRIVETRAIN_PORT = 42;
		public static final int REAR_LEFT_DRIVETRAIN_PORT = 1;
		public static final int FRONT_RIGHT_DRIVETRAIN_PORT = 2;
		public static final int REAR_RIGHT_DRIVETRAIN_PORT = 3;
		
		//Shooter
		
		public static final int SHOOTER_PORT = 4;
		
		//Blender
		
		public static final int BLENDER_PORT = 5;
		
		//Climber
		
		public static final int LEFT_CLIMBER_PORT = 6;
		public static final int RIGHT_CLIMBER_PORT = 7;
		//Agitator
		public static final int AGITATOR_PORT = 8;
		
	//Pneumatics
		
		public static final int DRIVETRAIN_SHIFTER_PORT = 0;
		public static final int GEAR_PUSHER_PORT_1 = 1;
		public static final int GEAR_PUSHER_PORT_2 = 2;
		public static final int GEAR_CLAMP_PORT_1 = 3;
		public static final int GEAR_CLAMP_PORT_2 = 4;
		public static final int HOPPER_FLAP_PORT = 5;
		
	//Analog Sensors
		
		public static final int GYRO_PORT = 0;
		
	//Digital Sensors
		
		//Drivetrain
		
		public static final int ULTRASONIC_PORT = 0;
		
		//Shooter
		
		public static final int SHOOTER_ENCODER_PORT_A = 1;
		public static final int SHOOTER_ENCODER_PORT_B = 2;
		
		//Gear
		
		public static final int GEAR_DETECTOR_PORT = 0;
		public static final int GEAR_TRANSMITTER_PORT = 1;
		
		public static final int GEAR_LED_PORT = 0;
	
		//Pixy
	
		public static final int PIXY_POWER_PORT = 2;
		public static final int PIXY_DEVICE_ADDRESS = 0x54;
		
		
	//Controls
		
		public static final int LOGITECH_PORT = 0;
		public static final int LEFT_JOYSTICK_PORT = 1;
		public static final int RIGHT_JOYSTICK_PORT = 2;
	
		public static final int LOGI_A_BUTTON          = 1;
		public static final int LOGI_B_BUTTON          = 2;
		public static final int LOGI_X_BUTTON          = 3;
		public static final int LOGI_Y_BUTTON          = 4;
	
		public static final int LOGI_LEFT_BUMPER       = 5;
		public static final int LOGI_RIGHT_BUMPER      = 6;
		public static final int LOGI_LEFT_TRIGGER      = 7;
		public static final int LOGI_RIGHT_TRIGGER     = 8;
	
		public static final int LOGI_BACK_BUTTON       = 9;
		public static final int LOGI_START_BUTTON      = 10;
	
		public static final int LOGI_LEFT_CLICK_STICK  = 11;
		public static final int LOGI_RIGHT_CLICK_STICK = 12;
	
		public static final double LOGI_LEFT_STICK_X   = 0;
		public static final double LOGI_LEFT_STICK_Y   = 1;
		public static final double LOGI_RIGHT_STICK_X  = 2;
		public static final double LOGI_RIGHT_STICK_Y  = 3;
}
