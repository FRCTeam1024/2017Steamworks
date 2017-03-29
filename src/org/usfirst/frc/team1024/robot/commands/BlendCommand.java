package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BlendCommand extends Command {
	double time;
	boolean isDone;
	
	public BlendCommand() {
		
	}
	public BlendCommand(double time) {
		this.time = time;
	}
	
	@Override
	protected void initialize() {}
	
	@Override
	protected void execute() {
		Robot.blender.blend(-1.0);
	}
	
	@Override
	protected boolean isFinished() {
		return false; //We always want this to run forever until the command is canceled
	}
	
	@Override
	protected void end() {
		Robot.blender.stop();
	}
	
	@Override
	protected void interrupted() {
		Robot.blender.stop();
	}

}
