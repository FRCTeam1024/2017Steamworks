package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CloseClamp extends Command {

	public CloseClamp() {
		requires(Robot.gear);
	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		Robot.gear.clamp.set(true);
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
