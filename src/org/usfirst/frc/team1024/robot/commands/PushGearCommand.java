package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class PushGearCommand extends Command {
	boolean isDone;
	public PushGearCommand() {
	}
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		Robot.gear.push(true);
		//isDone = true;
	}
	
	@Override
	protected boolean isFinished() {
		return isDone;
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
