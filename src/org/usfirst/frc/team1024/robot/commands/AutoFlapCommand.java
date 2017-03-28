package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoFlapCommand extends Command {
	boolean isDone = false;
	public AutoFlapCommand() {

	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Robot.hopper.flip(true);
		System.out.println("IN FLAP");
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