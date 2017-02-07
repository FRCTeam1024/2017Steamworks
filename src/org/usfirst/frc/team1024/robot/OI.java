package org.usfirst.frc.team1024.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	public Logitech logi;
	public Joystick lJoy;
	public Joystick rJoy;
	public OI() {
		logi = new Logitech(0);
		lJoy = new Joystick(1);
		rJoy = new Joystick(2);
	}
	
	/**
	 * 
	 */
	public void outputToSmartDashboard() {
		SmartDashboard.getBoolean("X", logi.getRawButton(1));
	}
	
	/**
	 * 
	 * @return state of the left bumper
	 */
	public boolean getGearClampOpen() {
		return logi.getButtonLB();
	}
	
	/**
	 * 
	 * @return state of left trigger
	 */
	public boolean getGearClampClose() {
		return logi.getButtonLT();
	}
	
	/**
	 * 
	 * @return state of Y button
	 */
	public boolean getGearPush() {
		return logi.getButtonY();
	}
	
	/**
	 * 
	 * @return state of east D-Pad button
	 */
	public boolean getShooterSpeedIncrease() {
		return logi.getDPadEast();
	}
	
	/**
	 * 
	 * @return state of west D-Pad button
	 */
	public boolean getShooterSpeedDecrease() {
		return logi.getDPadWest();
	}
	
	/**
	 * 
	 * @return Y state of left analog stick
	 */
	public double getBlendSpeed() {
		return logi.getLeftY();
	}
	
	/**
	 * 
	 * @return Y state of right analog stick
	 */
	public double getClimbAbsSpeed() {
		return logi.getRightY();
	}
	
	/**
	 * 
	 * @return state of right trigger
	 */
	public boolean getShoot() {
		return logi.getButtonRT();
	}
}