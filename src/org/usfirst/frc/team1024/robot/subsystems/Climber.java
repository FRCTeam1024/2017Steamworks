package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.Subsystem;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Change Log:
 * 1/26/17: added climber motors and Livewindow stuff
 * 1/28/2017: Added the climb(power), stop, getCurrent, eStop, override, and climb(preset) commands
 * 1/30/2017: Added javadocs
 * 1/31/2017: Now implements our subsystem interface
 */
public class Climber implements Subsystem {
	public final CANTalon leftClimber  = new CANTalon(RobotMap.LEFT_CLIMBER_PORT);
	public final CANTalon rightClimber = new CANTalon(RobotMap.RIGHT_CLIMBER_PORT);
	public Climber() {
		LiveWindow.addActuator("Climber", "Left Motor",  leftClimber);
		LiveWindow.addActuator("Climber", "Right Motor", rightClimber);
	}
	
	/**
	 * Sets the climber motors to a preset power
	 */
	public void climb() {
		leftClimber.set(1.0); // Set this later
		rightClimber.set(1.0); // Set this later
	}
	
	/**
	 * Sets the climber motors to a desired power
	 * @param power of the motor
	 */
	public void climb(double power) {
		leftClimber.set(power);
		rightClimber.set(power);
	}
	
	/**
	 * Stops the climber
	 */
	public void stop() {
		leftClimber.set(0.0);
		rightClimber.set(0.0);
	}
	
	/**
	 * Gets the current of the climber motor from the PDP
	 * @return current of the motor
	 */
	public double getCurrent(CANTalon motor) {
		return motor.getOutputCurrent();
	}
	
	public void emergencyStop() {
		
	}
	
	public void overrideSafety() {
		
	}
	/**
	 * Outputs motor properties to Smart Dashboard.
	 */
	@Override
	public void outputToSmartDashboard() {
		SmartDashboard.putData("Left Climber", leftClimber);
		SmartDashboard.putData("Right Climber", rightClimber);
	}
	
	@Override
	public void resetSensors() {
		
	}
	
}

