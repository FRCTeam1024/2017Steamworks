package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.DriveForTime;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;
import org.usfirst.frc.team1024.robot.commands.ShootCommand;
import org.usfirst.frc.team1024.robot.util.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos1NorthPeg extends CommandGroup {

	public Pos1NorthPeg() {
		addSequential(new DriveForDistance(0.5, 200)); // Set this distance
														// Later
		addSequential(new ShootCommand());
		addSequential(new TurnCommand(0.5, 135));
		addSequential(new DriveForDistance(0.5, 1800)); // Set this distance
														// Later
		addSequential(new TurnCommand(0.5, 45));
		addSequential(new DriveForDistance(0.5, 600));
		addSequential(new TurnCommand(0.5, 0));
		// addSequential(new GearClampCommand());
		addSequential(new PushGearCommand(true));
		addSequential(new DriveForTime(-0.5, 1.0));
		// make it so that "isFinished" returns True
	}

	protected void initialize() {
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {

	}
}
