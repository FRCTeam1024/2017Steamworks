package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForTime extends Command {
	double power;
	double time;
	double leftPower;
	double rightPower;
	int type;
	boolean isDone;
	
	/**
	 * Drives all drivetrain motors for a given time and powers.
	 * @param power
	 * @param time
	 */
	public DriveForTime(double power, double time) {
		this();
		this.power = power;
		this.time = time;
		type = 0;
		requires(Robot.drivetrain);
	}
	
	/**
	 * Drives all drivetrain motors for a given time and powers.
	 * @param leftPower (-1.0, 1.0)
	 * @param rightPower (-1.0, 1.0)
	 * @param time (seconds)
	 */
	public DriveForTime(double leftPower, double rightPower, double time) {
		this();
		this.leftPower = leftPower;
		this.rightPower = rightPower;
		this.time = time;
		type = 1;
	}
	
	private DriveForTime() {
		requires(Robot.drivetrain);
	}
	
	@Override
	protected void execute() {
		switch(type) {
			case 0:
				Robot.drivetrain.driveForTime(power, time);
				isDone = true;
				break;
			case 1:
				Robot.drivetrain.driveForTime(leftPower, rightPower, time);
				isDone = true;
				break;
		}
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isDone;
	}

}
