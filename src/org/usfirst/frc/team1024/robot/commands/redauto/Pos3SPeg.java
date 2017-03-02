package org.usfirst.frc.team1024.robot.commands.redauto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.DriveForTime;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos3SPeg extends CommandGroup {
	
	public Pos3SPeg() {
		
	//Drives towards the first position
	addSequential(new DriveForDistance(0.7, 200)); //Set this later
	//Turns to face the south peg
	addSequential(new TurnCommand(0.7, -90)); //Set this later
	//Drives toward the peg
	addSequential(new DriveForDistance(0.7, 100));
	//Aligns with the peg
	addSequential(new TurnCommand(0.7, 45));
	//Drives some extra distance to reach the peg
	addSequential(new DriveForDistance(0.4, 7));
	//Pushes the gear onto the peg
	addSequential(new PushGearCommand()); //This command or "GearClampCommand"
	//Retracts
	addSequential(new DriveForTime(0.5, 3));
	
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
