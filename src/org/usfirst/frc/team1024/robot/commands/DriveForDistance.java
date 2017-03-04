package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForDistance extends Command{
	double power;
	double distance;
	int type;
	boolean isDone;
	float timeToWait;
	
	
	/**
	 * Drives with PID to a distance. Changes the Talon Control Mode to position mode
	 * @param distance (inches)
	 * @param timeToWait (sec) The time to wait from the command being started to the command triggering isDone;
	 */
	public DriveForDistance(double distance, float timeToWait) {
		this.distance = distance;
		this.timeToWait = timeToWait;
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
				Timer time = new Timer();
				time.reset();
				time.start();
				double startTime = time.get();
				Robot.drivetrain.frontLeftDrive.setEncPosition(0); //Reset encoders
				Robot.drivetrain.frontRightDrive.setEncPosition(0);
				Robot.drivetrain.driveToDistance(distance); //PID
				while (time.get() < startTime + timeToWait && Robot.oi.getBreakButton() == false) {
					SmartDashboard.putNumber("Time", time.get());
					System.out.println("IN Drive to distance");
				}
				time.reset();
				isDone = true;
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
		return isDone; //replace with isDone later
	}
	
	
}
