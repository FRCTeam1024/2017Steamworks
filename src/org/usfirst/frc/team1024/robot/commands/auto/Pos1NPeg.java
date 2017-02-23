package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos1NPeg extends CommandGroup {
	
	public Pos1NPeg() {
		//Set all later
		
		//Drives towards the south peg from position 1
		addSequential(new DriveForDistance(0.8, 105));
		//Turns toward the south peg
		addSequential(new TurnCommand(0.6, 45));
		//Drives a bit further
		addSequential(new DriveForDistance(0.3, 15)); //Necessary?
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