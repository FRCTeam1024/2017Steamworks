package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.Robot;
import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos1NPeg extends CommandGroup {
	
	public Pos1NPeg() {
		

	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		
		//Goes to shooting position and shoots
		addSequential(new Pos1Shooting());
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
		addSequential(new PushGearCommand(true));
		//Turns back to its previous position
		addSequential(new TurnCommand(0.4, 35)); //Set this Later
		//Retracts
		addSequential(new DriveForDistance(0.5, -90)); //Set this Later
		
	}
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.gear.push(false);
	}
	
	@Override
	protected void interrupted() {
		Robot.gear.push(false);
	}
}
