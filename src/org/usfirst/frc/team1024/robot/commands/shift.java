package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class shift extends Command {
	String state;
	public shift(String state) {
		this.state = state;
	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		if (state.equals("Low")) {
			Robot.drivetrain.shifter.set(false);
		} else if (state.equals("High")) {
			Robot.drivetrain.shifter.set(true);
		} else {
			Robot.drivetrain.shifter.set(true);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
	}
	
	@Override
	protected void interrupted() {
	}
}
