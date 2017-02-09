package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command {
	
	public Climb() {
		
	}

	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		Robot.climber.climb();
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