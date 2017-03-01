package org.usfirst.frc.team1024.robot.commands.redauto;

import org.usfirst.frc.team1024.robot.commands.Drive2Inputs;
import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.DriveForTime;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos3NPegShoot extends CommandGroup {
	
	public Pos3NPegShoot() {
		//Set all later
		
		//Goes through the protocol for "Pos3NPeg"
		addSequential(new Pos3NPeg());
		//Straightens out the robot
		addSequential(new TurnCommand(0.6, 45));
		//Retracts to pos 3
		addSequential(new DriveForDistance(0.7, 87));
		//Aligns with wall
		addSequential(new Drive2Inputs(1.0, 0.0, 270));
		//Executes pos 3 shooting
		addSequential(new Pos3Shooting());
		
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
