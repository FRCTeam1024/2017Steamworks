package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;
import org.usfirst.frc.team1024.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;

public class PushGearCommand extends Command {

	public PushGearCommand() {
		requires(Robot.gear);
	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		Robot.gear.pusher.set(true);
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