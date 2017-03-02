package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {
	double leftPower;
	double rightPower;
	boolean isDone = false;
	float time = 0.0f;
	public DriveCommand(double leftPower, double rightPower, float time) {
		this.leftPower = leftPower;
		this.rightPower = rightPower;
		this.time = time;
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		Robot.drivetrain.drive(leftPower, rightPower);
		Timer.delay(time);
		isDone = true;
	}
	
	@Override
	protected boolean isFinished() {
		return isDone;
	}
	
	@Override
	protected void end() {
		Robot.drivetrain.stop();
	}
	
	@Override
	protected void interrupted() {
		Robot.drivetrain.stop();
	}
}