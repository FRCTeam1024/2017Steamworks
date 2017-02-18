package org.usfirst.frc.team1024.robot.commands.auto;
import org.usfirst.frc.team1024.robot.commands.DriveForDistance;

import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class Pos2WPeg extends CommandGroup {
	
	
	public Pos2WPeg() {

	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		
		//Goes through the protocol for Position 2 Shooting.
		addSequential(new Pos2Shooting());
		//Turns a certain amount.
		addSequential(new TurnCommand(0.5, 135)); //Set this Later
		//Drives forward so that, by turning, it's in line with W peg.
		addSequential(new DriveForDistance(0.5, 96.25)); //Set this later
		//Turns to be facing W peg.
		addSequential(new TurnCommand(0.5, -90)); //Set this later
		//Drives to W peg.
		addSequential(new DriveForDistance(0.5, 46.95)); //Set this later
		//Place gear on W peg.
		addSequential(new PushGearCommand(true));
		//Drive back from W peg.
		addSequential(new DriveForDistance(0.5, -46.95)); //Set this later
		
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
