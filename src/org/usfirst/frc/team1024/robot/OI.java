package org.usfirst.frc.team1024.robot;

import org.usfirst.frc.team1024.robot.commands.CloseClampCommand;
import org.usfirst.frc.team1024.robot.commands.OpenClampCommand;
import org.usfirst.frc.team1024.robot.commands.GearPushCommand;
import org.usfirst.frc.team1024.robot.commands.GearRetractCommand;
import org.usfirst.frc.team1024.robot.commands.ShootCommand;
import org.usfirst.frc.team1024.robot.commands.ShooterSpeedDecreaseCommand;
import org.usfirst.frc.team1024.robot.commands.ShooterSpeedIncreaseCommand;
import org.usfirst.frc.team1024.robot.commands.ShooterSpeedResetCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public Logitech logi;
	public Joystick lJoy;
	public Joystick rJoy;
	public Button gearClampOpenButton;
	public Button gearClampCloseButton;
	public Button gearPushButton;
	public Button shooterSpeedIncreaseButton;
	public Button shooterSpeedDecreaseButton;
	public Button shootButton;
	public Button speedResetButton;
	
	public OI() {
		logi = new Logitech(RobotMap.LOGITECH_PORT);
		lJoy = new Joystick(RobotMap.LEFT_JOYSTICK_PORT);
		rJoy = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);
		
		gearClampOpenButton = new JoystickButton(logi, 5);
		gearClampCloseButton = new JoystickButton(logi, 7);
		gearPushButton = new JoystickButton(logi, 4);
		
		shootButton = new JoystickButton(logi, 2);
		shooterSpeedIncreaseButton = new JoystickButton(logi, 1);
		shooterSpeedDecreaseButton = new JoystickButton(logi, 1);
		speedResetButton = new JoystickButton(logi, 6);
		
		gearClampOpenButton.whenPressed(new OpenClampCommand());
		gearClampCloseButton.whenPressed(new CloseClampCommand());
		gearPushButton.whenPressed(new GearPushCommand());
		gearPushButton.whenReleased(new GearRetractCommand());
		
		shootButton.whenPressed(new ShootCommand());
		shooterSpeedIncreaseButton.whileHeld(new ShooterSpeedIncreaseCommand());
		shooterSpeedDecreaseButton.whileHeld(new ShooterSpeedDecreaseCommand());
		speedResetButton.whenPressed(new ShooterSpeedResetCommand());
		
		
	}
	
	/**
	 * Outputs data to the SmartDashboard
	 */
	public void outputToSmartDashboard() {
		
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