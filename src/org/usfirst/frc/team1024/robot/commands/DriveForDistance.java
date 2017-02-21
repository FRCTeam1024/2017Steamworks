package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForDistance extends Command{
	double power;
	double distance;
	int type;
	boolean isDone;
	
	/**
	 * Drives with PID to a distance. Changes the Talon Control Mode to position mode
	 * @param distance (inches)
	 */
	public DriveForDistance(double distance) {
		this.distance = distance;
		type = 0;
	}
	
	/**
	 * Drives the drivetrain motors for a specified distance and power.
	 * @param power (-1.0, 1.0)
	 * @param distance (inches)
	 */
	public DriveForDistance(double power, double distance) {
		this.power = power;
		this.distance  = distance;
		type = 1;
	}
	
	@Override
	protected void execute() {
		switch(type) {
			case 0:
				Robot.drivetrain.driveToDistance(distance); //PID
				break;
			case 1:
				Robot.drivetrain.driveForDistance(power, distance); //NON-PID
				isDone = true;
				break;
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false; //replace with isDone later
	}
	
	
}
