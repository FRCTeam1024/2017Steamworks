package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos2NPeg extends CommandGroup {
	
	public Pos2NPeg() {
		//Set all later
		
		//Drives towards the north peg from position 2
		addSequential(new DriveForDistance(0.7, 70));
		//Turns toward the north peg
		addSequential(new TurnCommand(0.6, -90));
		//Drives a bit further
		addSequential(new DriveForDistance(0.3, 90));
		//Turns to actually face the peg
		addSequential(new TurnCommand(0.5, -40));
		//Drives a bit forward
		addSequential(new DriveForDistance(0.2, 12));
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

