package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 * @author team1024
 * Change Log:
 * 1/26/17: added all motors, added drive and stop commands, added shifter
 * 1/28/2017: Added commands for full drive, preset drive, and driveForTime
 */
public class Drivetrain extends Subsystem {
	public final CANTalon frontLeftDrive   = new CANTalon(RobotMap.FRONT_LEFT_DRIVETRAIN_PORT);
	public final CANTalon middleLeftDrive  = new CANTalon(RobotMap.MIDDLE_LEFT_DRIVETRAIN_PORT);
	public final CANTalon rearLeftDrive    = new CANTalon(RobotMap.REAR_LEFT_DRIVETRAIN_PORT);
	public final CANTalon frontRightDrive  = new CANTalon(RobotMap.FRONT_RIGHT_DRIVETRAIN_PORT);
	public final CANTalon middleRightDrive = new CANTalon(RobotMap.MIDDLE_RIGHT_DRIVETRAIN_PORT);
	public final CANTalon rearRightDrive   = new CANTalon(RobotMap.REAR_RIGHT_DRIVETRAIN_PORT);
	
	public final Solenoid shifter 		   = new Solenoid(RobotMap.DRIVETRAIN_SHIFTER_PORT);
	
	public Drivetrain() {
		LiveWindow.addActuator("Drivetrain", "FrontLeft Motor",   frontLeftDrive);
		LiveWindow.addActuator("Drivetrain", "MiddleLeft Motor",  middleLeftDrive);
		LiveWindow.addActuator("Drivetrain", "RearLeft Motor",    rearLeftDrive);
		LiveWindow.addActuator("Drivetrain", "FrontRight Motor",  frontRightDrive);
		LiveWindow.addActuator("Drivetrain", "MiddleRight Motor", middleRightDrive);
		LiveWindow.addActuator("Drivetrain", "RearRight Motor",   rearRightDrive);

	}

	public void drive(double power) {
		frontLeftDrive.set(power);
		middleLeftDrive.set(power);
		rearLeftDrive.set(power);
		frontRightDrive.set(power);
		middleRightDrive.set(power);
		rearRightDrive.set(power);
	}
	
	public void drive(double leftpower, double rightpower) {
		frontLeftDrive.set(leftpower);
		middleLeftDrive.set(leftpower);
		rearLeftDrive.set(leftpower);
		frontRightDrive.set(rightpower);
		middleRightDrive.set(rightpower);
		rearRightDrive.set(rightpower);
		
	}

	public void drive() {
		frontLeftDrive.set(1.0); // Set this later
		middleLeftDrive.set(1.0); // Set this later
		rearLeftDrive.set(1.0); // Set this later
		frontRightDrive.set(1.0); // Set this later
		middleRightDrive.set(1.0); // Set this later
		rearRightDrive.set(1.0); // Set this later
	}
	
	public void stop() {
		frontLeftDrive.set(0.0);
		middleLeftDrive.set(0.0);
		rearLeftDrive.set(0.0);
		frontRightDrive.set(0.0);
		middleRightDrive.set(0.0);
		rearRightDrive.set(0.0);
	}
	
	public void driveForTime(double time, double power) {
		
	}
	
	public void initDefaultCommand() {
		
	}
}
