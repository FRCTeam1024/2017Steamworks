package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos2WPeg extends CommandGroup {
	public Pos2WPeg() {
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		// addSequential(new DriveForDistance);
		/*
		addSequential(new TurnCommand(0.5, 135)); //Set this Later
		//Drives to center, in line with W peg
		addSequential(new DriveForDistance(0.5, 96.25)); //Set this later
		//Turns to be facing W peg
		addSequential(new TurnCommand(0.5, -90)); //Set this later
		//Drive to W peg
		addSequential(new DriveForDistance(0.5, 46.95)); //Set this later
		//Place gear on W peg
		addSequential(new PushGearCommand(true));
		//Drive back from W peg
		addSequential(new DriveForDistance(0.5, -46.95)); //Set this later
		*/
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
