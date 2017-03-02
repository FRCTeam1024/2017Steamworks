package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive2Inputs extends Command {
	double leftPower;
	double rightPower;
	double desiredAngle;
	boolean isDone = false;
	public Drive2Inputs(double leftPower, double rightPower, double desiredangle) { 
		this.leftPower = leftPower;
		this.rightPower = rightPower;
		this.desiredAngle = desiredangle;
	}
	@Override
	protected void initialize() {
		Robot.drivetrain.navx.reset();
	}
	@Override
	protected void execute() {
		if (desiredAngle > 0) {
			while (Robot.drivetrain.navx.getYaw() < desiredAngle) {
				Robot.drivetrain.drive(-leftPower, rightPower);
				isDone = true;
			}
		} else if (desiredAngle < 0) {
			while(Robot.drivetrain.navx.getYaw() > desiredAngle) {
				Robot.drivetrain.drive(leftPower, -rightPower);
				isDone = true;
			}
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
