package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.DriveForTime;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos1WPeg extends CommandGroup{
	
	public Pos1WPeg() {
		//Set all later
		
		//Drives toward the 2nd position.
		addSequential(new DriveForDistance(0.7, 50));
		//Turns toward the peg.
		addSequential(new TurnCommand(0.6, -90));
		//Drives towards the south peg from position 1
		addSequential(new DriveForDistance(0.8, 95));
		//Pushes the gear onto the peg
		addSequential(new PushGearCommand()); //FILL IN PLEASE!!!!!!!!
		//Retracts
		addSequential(new DriveForDistance(0.5, -30));
		
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
