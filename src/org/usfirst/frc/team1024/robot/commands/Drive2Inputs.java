package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive2Inputs extends Command {
	double leftPower;
	double rightPower;
	double desiredangle;
	boolean isDone = false;
	public Drive2Inputs(double leftPower, double rightPower, double desiredangle) { 
		this.leftPower = leftPower;
		this.rightPower = rightPower;
		this.desiredangle = desiredangle;
	}
	@Override
	protected void initialize() {}
	@Override
	protected void execute() {
		while (Robot.drivetrain.gyro.getAngle() < desiredangle) {
			Robot.drivetrain.drive(leftPower, rightPower);
			isDone = true;
		}
	}
	@Override
	protected boolean isFinished() { 
		return isDone; 
	}
	@Override
	protected void end() {}
	@Override
	protected void interrupted() {}
}
