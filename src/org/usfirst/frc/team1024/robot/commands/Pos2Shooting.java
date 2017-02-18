package org.usfirst.frc.team1024.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos2Shooting extends CommandGroup {
	public Pos2Shooting() {
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		// Drive away from wall
		addSequential(new DriveForDistance(0.5, 1)); // Set this later
		// Turn to face shooting position
		addSequential(new TurnCommand(0.5, -90)); // Set this later
		// Drive to shooting position
		addSequential(new DriveForDistance(0.5, 138.7)); // Set this later
		// Turn to aim shooter at boiler
		addSequential(new TurnCommand(0.5, 45)); // Set this later
		// Shoot until you can't shoot no more
		addSequential(new ShootCommand());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
