package org.usfirst.frc.team1024.robot.commands.redauto;
import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.DriveForTime;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;
import org.usfirst.frc.team1024.robot.util.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class Pos2ShootWPeg extends CommandGroup {
	
	
	public Pos2ShootWPeg() {
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
		addSequential(new PushGearCommand());//?!?!?!??!?!
		//Drive back from W peg.
		addSequential(new DriveForDistance(0.5, -46.95)); //Set this later
	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {

		addSequential(new DriveForDistance(0.5, Constants.DISTANCE_TO_BASELINE - Constants.ROBOT_WIDTH));
		// addSequential(new GearClampCommand());
		addSequential(new PushGearCommand());
		addSequential(new DriveForTime(-0.5, 1.0));
		// make it so that "isFinished" returns True

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
