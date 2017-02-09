package org.usfirst.frc.team1024.robot;

import org.usfirst.frc.team1024.robot.commands.Blend;
import org.usfirst.frc.team1024.robot.commands.Climb;
import org.usfirst.frc.team1024.robot.commands.CloseClamp;
import org.usfirst.frc.team1024.robot.commands.OpenClamp;
import org.usfirst.frc.team1024.robot.commands.Push;
import org.usfirst.frc.team1024.robot.commands.Shoot;
import org.usfirst.frc.team1024.robot.commands.SpeedDecreasing;
import org.usfirst.frc.team1024.robot.commands.SpeedIncreasing;
import org.usfirst.frc.team1024.robot.commands.SpeedReset;
import org.usfirst.frc.team1024.robot.subsystems.Gear;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	public Logitech logi;
	public Joystick lJoy;
	public Joystick rJoy;
	public Button gearClampOpen;
	public Button gearClampClose;
	public Button gearPush;
	public Button shooterSpeedIncrease;
	public Button shooterSpeedDecrease;
	public Button blend;
	public Button climb;
	public Button shoot;
	public Button speedReset;
	Gear gear = new Gear();
	
	
	public OI() {
		logi = new Logitech(RobotMap.LOGITECH_PORT);
		lJoy = new Joystick(RobotMap.LEFT_JOYSTICK_PORT);
		rJoy = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);
		
		gearClampOpen = new JoystickButton(logi, 6);
		gearClampClose = new JoystickButton(logi, 2);
		gearPush = new JoystickButton(logi, 3);
		shooterSpeedIncrease = new JoystickButton(logi, 4);
		shooterSpeedDecrease= new JoystickButton(logi, 5);
		blend = new JoystickButton(logi, 6);
		climb = new JoystickButton(logi, 7);
		shoot = new JoystickButton(logi, 8);
		speedReset = new JoystickButton(logi, 9);
		 
		gearClampOpen.whenPressed(new OpenClamp());
		gearClampClose.whenPressed(new CloseClamp());
		gearPush.whenPressed(new Push());
		shooterSpeedIncrease.whenPressed(new SpeedIncreasing());
		shooterSpeedDecrease.whenPressed(new SpeedDecreasing());
		blend.whenPressed(new Blend());
		climb.whenPressed(new Climb());
		shoot.whenPressed(new Shoot());
		speedReset.whenPressed(new SpeedReset());
	}
	
	/**
	 * Outputs data to the SmartDashboard
	 */
	public void outputToSmartDashboard() {
		//SmartDashboard
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

	/**
	 * 
	 * @return state of right bumper
	 */
	public boolean getSpeedReset() {
		return logi.getButtonRB();
	}
}