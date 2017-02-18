package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos1SPeg extends CommandGroup {
	
	public Pos1SPeg() {
	
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		
		//Goes to shooting position and shoots
		addSequential(new Pos1Shooting());
		//Turn to move towards S peg
		addSequential(new TurnCommand(0.5, 45)); //Set this later
		//Drive towards S peg
		addSequential(new DriveForDistance(0.5, 46.95)); //Set this later
		//Turn to face S peg
		addSequential(new TurnCommand(0.5, 60)); //Set this later
		//Drive towards S peg
		addSequential(new DriveForDistance(0.5, 45)); //Set this later
		//Place gear on S peg
		addSequential(new PushGearCommand(true)); //Set this later
		//Drive away from S peg
		addSequential(new DriveForDistance(0.5, -10)); //Set this later
		
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
