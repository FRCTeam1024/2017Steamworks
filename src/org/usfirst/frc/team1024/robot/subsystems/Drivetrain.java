package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.Constants;
import org.usfirst.frc.team1024.robot.util.Subsystem;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * @author team1024
 * Change Log:
 * 1/26/17: added all motors, added drive and stop commands, added shifter
 * 1/28/2017: Added commands for full drive, preset drive, and driveForTime
 * 1/30/2017: Added javadocs
 * 1/31/2017: Now implements our subsystem interface
 */
public class Drivetrain implements Subsystem {
	public final CANTalon frontLeftDrive   		= new CANTalon(RobotMap.FRONT_LEFT_DRIVETRAIN_PORT);
	public final CANTalon middleLeftDrive  		= new CANTalon(RobotMap.MIDDLE_LEFT_DRIVETRAIN_PORT);
	public final CANTalon rearLeftDrive    		= new CANTalon(RobotMap.REAR_LEFT_DRIVETRAIN_PORT);
	public final CANTalon frontRightDrive  		= new CANTalon(RobotMap.FRONT_RIGHT_DRIVETRAIN_PORT);
	public final CANTalon middleRightDrive 		= new CANTalon(RobotMap.MIDDLE_RIGHT_DRIVETRAIN_PORT);
	public final CANTalon rearRightDrive   		= new CANTalon(RobotMap.REAR_RIGHT_DRIVETRAIN_PORT);
	
	public final Solenoid shifter 		   		= new Solenoid(RobotMap.DRIVETRAIN_SHIFTER_PORT);
	
	public final Encoder leftDrivetrainEncoder  = new Encoder(RobotMap.LEFT_DRIVETRAIN_ENCODER_PORT_A,
															  RobotMap.LEFT_DRIVETRAIN_ENCODER_PORT_B);
	public final Encoder rightDrivetrainEncoder = new Encoder(RobotMap.RIGHT_DRIVETRAIN_ENCODER_PORT_A,
															  RobotMap.RIGHT_DRIVETRAIN_ENCODER_PORT_B);
	public final AnalogGyro gyro 				= new AnalogGyro(RobotMap.GYRO_PORT);
	
	public Drivetrain() {
		LiveWindow.addActuator("Drivetrain", "FrontLeft Motor",   frontLeftDrive);
		LiveWindow.addActuator("Drivetrain", "MiddleLeft Motor",  middleLeftDrive);
		LiveWindow.addActuator("Drivetrain", "RearLeft Motor",    rearLeftDrive);
		LiveWindow.addActuator("Drivetrain", "FrontRight Motor",  frontRightDrive);
		LiveWindow.addActuator("Drivetrain", "MiddleRight Motor", middleRightDrive);
		LiveWindow.addActuator("Drivetrain", "RearRight Motor",   rearRightDrive);
		
		LiveWindow.addSensor("Sensors", "Left Drive Encoder",  leftDrivetrainEncoder);
		LiveWindow.addSensor("Sensors", "Right Drive Encoder", rightDrivetrainEncoder);
		LiveWindow.addSensor("Sensors", "Gyro", 			   gyro);
	}
	
	/**
	 * Sets the drivetrain motors to a preset value
	 */
	public void drive() {
		frontLeftDrive.set(1.0); // Set this later
		middleLeftDrive.set(1.0); // Set this later
		rearLeftDrive.set(1.0); // Set this later
		frontRightDrive.set(1.0); // Set this later
		middleRightDrive.set(1.0); // Set this later
		rearRightDrive.set(1.0); // Set this later
	}
	
	/**
	 * Drive all motors with all power
	 * @param power
	 */
	public void drive(double power) {
		frontLeftDrive.set(power);
		middleLeftDrive.set(power);
		rearLeftDrive.set(power);
		frontRightDrive.set(power);
		middleRightDrive.set(power);
		rearRightDrive.set(power);
	}
	
	/**
	 * Sets the drivetrain motors with left and right powers
	 * @param leftpower
	 * @param rightpower
	 */
	public void drive(double leftpower, double rightpower) {
		frontLeftDrive.set(leftpower);
		middleLeftDrive.set(leftpower);
		rearLeftDrive.set(leftpower);
		frontRightDrive.set(rightpower);
		middleRightDrive.set(rightpower);
		rearRightDrive.set(rightpower);
		
	}
	
	/**
	 * Stops all drivetrain motors
	 */
	public void stop() {
		frontLeftDrive.set(0.0);
		middleLeftDrive.set(0.0);
		rearLeftDrive.set(0.0);
		frontRightDrive.set(0.0);
		middleRightDrive.set(0.0);
		rearRightDrive.set(0.0);
	}
	
	public void driveForTime(double time, double leftPower, double rightPower){
		drive(leftPower, rightPower);
		Timer.delay(time);
		stop();
	}
	
	/**
	 * Outputs motor properties to SM
	 */
	@Override
	public void outputToSmartDashboard() {
		SmartDashboard.putData("Front Left Drive",   frontLeftDrive);
		SmartDashboard.putData("Middle Left Drive",  middleLeftDrive);
		SmartDashboard.putData("Rear Left Drive",    rearLeftDrive);
		SmartDashboard.putData("Front Right Drive",  frontRightDrive);
		SmartDashboard.putData("Middle Right Drive", middleRightDrive);
		SmartDashboard.putData("Rear Right Drive",   rearRightDrive);
	}
	
	/**
	 * 
	 */
	@Override
	public void resetSensors() {
    	leftDrivetrainEncoder.reset();
    	rightDrivetrainEncoder.reset();
    	gyro.reset();
	}
	
	public void driveForDistance(double distance, double power) {
		while ((leftDrivetrainEncoder.getDistance() + rightDrivetrainEncoder.getDistance()) / 2 <
			  (Constants.ENCODER_CONSTANT_INCHES * distance)) {
			drive(power);
		}
		
	}
	
}
