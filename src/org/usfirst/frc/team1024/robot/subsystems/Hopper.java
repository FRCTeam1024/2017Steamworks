package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1024.robot.util.KilaTalon;
import org.usfirst.frc.team1024.robot.util.Subsystem1024;

import edu.wpi.first.wpilibj.Solenoid;


import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Hopper extends Subsystem implements Subsystem1024 {

	public Solenoid flap = new Solenoid(RobotMap.HOPPER_FLAP_PORT);
	public KilaTalon agitator = new KilaTalon(RobotMap.AGITATOR_PORT);

	public Hopper() {
		LiveWindow.addActuator("Hopper", "Flap", flap);
		LiveWindow.addActuator("Hopper", "Agitator", agitator);
	}

	/**
	 * The agitatator runs at a preset power
	 */
	public void agitate() {
		agitator.set(1.0); // preset later
	}

	/**
	 * 
	 * The agitatator runs at a preset power
	 */
	public void agitate(double power) {
		agitator.set(power);
	}

	public void flap(boolean state) {
		flap.set(state);
	}

	@Override
	public void outputToSmartDashboard() {
		SmartDashboard.putData("Flap", flap);
		SmartDashboard.putData("Agitator", agitator);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resetSensors() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
