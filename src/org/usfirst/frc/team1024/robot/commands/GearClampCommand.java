package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GearClampCommand extends Command {
	int state = 0;
	boolean isDone;
	public GearClampCommand(int state) {
		requires(Robot.gear);
		this.state = state;
	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		Robot.gear.clamp(state);
		isDone = true;
	}
	
	@Override
	protected boolean isFinished() {
		return isDone;
	}
	
	@Override
	protected void end() {
	}
	
	@Override
	protected void interrupted() {
	}
}
