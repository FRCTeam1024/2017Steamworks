package org.usfirst.frc.team1024.robot;


import org.usfirst.frc.team1024.robot.commands.AgitateCommand;
import org.usfirst.frc.team1024.robot.commands.EmptyCommand;
import org.usfirst.frc.team1024.robot.commands.FlapCommand;

import org.usfirst.frc.team1024.robot.commands.GearClampCommand;
import org.usfirst.frc.team1024.robot.commands.OpenClampPushGearCommand;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.ShootCommand;
import org.usfirst.frc.team1024.robot.commands.ShooterSpeedResetCommand;

import org.usfirst.frc.team1024.robot.commands.shift;
import org.usfirst.frc.team1024.robot.util.Constants;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public Joystick logi;
	public Joystick lJoy;
	public Joystick rJoy;
	public Button gearClampOpenButton;
	public Button gearClampCloseButton;
	public Button gearClampOffButton;
	public Button gearPushButton;
	public Button shooterSpeedIncreaseButton;
	public Button shooterSpeedDecreaseButton;
	public Button shootButton;
	public Button speedResetButton;
	public Button hopperFlapButton;
	public Button shiftLowButtonL;
	public Button shiftHighButtonL;
	public Button shiftLowButtonR;
	public Button shiftHighButtonR;
	
	public OI() {
		logi = new Joystick(RobotMap.LOGITECH_PORT);
		lJoy = new Joystick(RobotMap.LEFT_JOYSTICK_PORT);
		rJoy = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);
		
		gearClampOpenButton = new JoystickButton(logi, 4);
		gearClampCloseButton = new JoystickButton(logi, 2);
		gearClampOffButton = new JoystickButton(logi, 1);
		
		gearPushButton = new JoystickButton(logi, 7);
		
		shootButton = new JoystickButton(logi, 8);
		speedResetButton = new JoystickButton(logi, 6);
		
		hopperFlapButton = new JoystickButton(logi, 3);
		/*
		shiftLowButtonL = new JoystickButton(lJoy, 7);
		shiftHighButtonL = new JoystickButton(lJoy, 10);
		
		shiftLowButtonR = new JoystickButton(rJoy, 7);
		shiftHighButtonR = new JoystickButton(rJoy, 10);
		*/
		
		
		
		gearClampOpenButton.whenPressed(new GearClampCommand(1));
		gearClampCloseButton.whenPressed(new GearClampCommand(-1));
		gearClampOffButton.whenPressed(new GearClampCommand(0));
		
		gearPushButton.whileHeld(new OpenClampPushGearCommand());
		
		shootButton.whileHeld(new ShootCommand());
		
		speedResetButton.whileHeld(new ShooterSpeedResetCommand());
		

		hopperFlapButton.whileHeld(new FlapCommand());
		/*
		shiftLowButtonL.whenPressed(new shift("Low"));
		shiftHighButtonL.whenPressed(new shift("High"));
		
		shiftLowButtonR.whenPressed(new shift("Low"));
		shiftHighButtonR.whenPressed(new shift("High"));
		*/
		

	}
	
	/**
	 * Outputs data to the SmartDashboard
	 */
	public void outputToSmartDashboard() {
		
	}

	public boolean getBreakButton() {
		// TODO Auto-generated method stub
		return logi.getRawButton(9);
	}
	
//	/**
//	 * 
//	 * @return state of the left bumper
//	 */
//	public boolean getGearClampOpen() {
//		return logi.getButtonLB();
//	}
//	
//	/**
//	 * 
//	 * @return state of left trigger
//	 */
//	public boolean getGearClampClose() {
//		return logi.getButtonLT();
//	}
//	
//	/**
//	 * 
//	 * @return state of Y button
//	 */
//	public boolean getGearPush() {
//		return logi.getButtonY();
//	}
//	
//	/**
//	 * 
//	 * @return state of east D-Pad button
//	 */
//	public boolean getShooterSpeedIncrease() {
//		return logi.getDPadEast();
//	}
//	
//	/**
//	 * 
//	 * @return state of west D-Pad button
//	 */
//	public boolean getShooterSpeedDecrease() {
//		return logi.getDPadWest();
//	}
//	
//	/**
//	 * 
//	 * @return Y state of left analog stick
//	 */
//	public double getBlendSpeed() {
//		return logi.getLeftY();
//	}
//	
//	/**
//	 * 
//	 * @return Y state of right analog stick
//	 */
//	public double getClimbAbsSpeed() {
//		return logi.getRightY();
//	}
//	
//	/**
//	 * 
//	 * @return state of right trigger
//	 */
//	public boolean getShoot() {
//		return logi.getButtonRT();
//	}
//
//	/**
//	 * 
//	 * @return state of right bumper
//	 */
//	public boolean getSpeedReset() {
//		return logi.getButtonRB();
//	}
}