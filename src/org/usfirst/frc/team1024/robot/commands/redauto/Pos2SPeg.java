package org.usfirst.frc.team1024.robot.commands.redauto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.DriveForTime;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos2SPeg extends CommandGroup {
	
	public Pos2SPeg() {
		//Set all later
		
		//Drives from pos 2 to pos 1
		addSequential(new DriveForDistance(0.7, 70)); 
		//Turns toward the south peg
		addSequential(new TurnCommand(0.5, 90));
		//Drives to south peg
		addSequential(new DriveForDistance(0.7, 96));
		//Turns to face the peg
		addSequential(new TurnCommand(0.5, 45));
		//Drives a bit further
		addSequential(new DriveForDistance(0.4, 3));
		//Pushes the gear onto the peg
		addSequential(new PushGearCommand());
		//Retracts
		addSequential(new DriveForTime(-0.7, 3.0));
	
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
