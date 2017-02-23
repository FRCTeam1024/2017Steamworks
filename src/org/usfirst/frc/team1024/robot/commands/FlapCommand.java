package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class FlapCommand extends Command {
	public FlapCommand() {
		
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		Robot.hopper.flap(true);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.hopper.flap(false);
	}
	
	@Override
	protected void interrupted() {
		Robot.hopper.flap(false);
	}
}
