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

		//Goes to shooting position and shoots
		addSequential(new Pos1Shoot());
		//Turns from the original position
		addSequential(new TurnCommand(0.4, 135)); //Set this Later
		//Drives a certain distance
		addSequential(new DriveForDistance(0.7, 100)); //Set this Later
		//Turns so that next drive command goes towards the peg
		addSequential(new TurnCommand(0.4, -90)); //Set this later
		//Drives a certain distance
		addSequential(new DriveForDistance(0.5, 90)); //Set this Later
		//Turns so that the gear can be accurately placed upon the peg
		addSequential(new TurnCommand(0.4, -35)); //Set this Later
		//Places the gear
		addSequential(new PushGearCommand());
		//Turns back to its previous position
		addSequential(new TurnCommand(0.4, 35)); //Set this Later
		//Retracts
		addSequential(new DriveForDistance(0.5, -90)); //Set this Later

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