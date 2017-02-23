package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.DriveForTime;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos1WPeg extends CommandGroup {
	public Pos1WPeg() {
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		// Goes to shooting position and shoots
		addSequential(new Pos1Shoot());
		// Turn away from shooting position
		addSequential(new TurnCommand(0.5, 90)); // Set this later.
		// Drive toward W peg
		addSequential(new DriveForDistance(0.5, 95.0)); // Set this later.
		// Turn towards W peg
		addSequential(new TurnCommand(0.5, -45)); // Set this later.
		// Place gear on W peg
		addSequential(new PushGearCommand()); // Set this later.
		// Drive away from W peg
		addSequential(new DriveForTime(-0.5, 1.0)); // Set this later.
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
