package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AgitateCommand extends Command {
	public AgitateCommand() {
		
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		Robot.hopper.agitate();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.hopper.agitate(0.0);
	}
	
	@Override
	protected void interrupted() {
		Robot.hopper.agitate(0.0);
	}
}
