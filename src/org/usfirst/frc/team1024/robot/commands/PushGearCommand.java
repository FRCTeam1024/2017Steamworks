package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PushGearCommand extends Command {
	boolean state;
	public PushGearCommand() {
		// this.state = state;
	}
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		Robot.gear.push(state);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.gear.push(false);
	}
	
	@Override
	protected void interrupted() {
		Robot.gear.push(false);
	}

}
