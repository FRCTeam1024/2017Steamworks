package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos2NPeg extends CommandGroup {

	public Pos2NPeg() {

	}

	protected void initialize() {
	}

	@Override
	protected void execute() {
		
		//Goes through protocol for position 2 shooting
		addSequential(new Pos2Shooting());
		//Turns a certain amount
		addSequential(new TurnCommand(0.5, 135)); // Set this later
		// Drives a certain distance
		addSequential(new DriveForDistance(0.7, 100)); // Set this Later
		// Turns so that next drive command goes towards the peg
		addSequential(new TurnCommand(0.4, -90)); // Set this later
		// Drives a certain distance
		addSequential(new DriveForDistance(0.5, 90)); // Set this Later
		// Turns so that the gear can be accurately placed upon the peg
		addSequential(new TurnCommand(0.4, -35)); // Set this Later
		// Places the gear
		addSequential(new PushGearCommand(true));
		// Turns back to its previous position
		addSequential(new TurnCommand(0.4, 35)); // Set this Later
		// Retracts
		addSequential(new DriveForDistance(0.5, -90)); // Set this Later

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
