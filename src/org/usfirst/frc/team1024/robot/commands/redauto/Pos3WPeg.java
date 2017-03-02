package org.usfirst.frc.team1024.robot.commands.redauto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.DriveForTime;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos3WPeg extends CommandGroup{
	
	public Pos3WPeg() {
		
		//Drives towards the second position
		addSequential(new DriveForDistance(0.6, 120)); //Set this later
		//Turns to face towards the peg
		addSequential(new TurnCommand(0.7, -90));
		//Drives towards the west peg
		addSequential(new DriveForDistance(0.7, 90)); //Set this later
		//Pushes the gear onto said peg
		addSequential(new PushGearCommand());//Is it "PushGearCommand" or "GearClampCommand"?
		//Retracts
		addSequential(new DriveForTime(0.7, 0.7, 4)); //Set this later
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