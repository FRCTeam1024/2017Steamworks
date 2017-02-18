package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.DriveForTime;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.util.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos2ShootWPeg extends CommandGroup {
	public Pos2ShootWPeg() {
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		addSequential(new DriveForDistance(0.5, Constants.DISTANCE_TO_BASELINE - Constants.ROBOT_WIDTH));
		// addSequential(new GearClampCommand());
		addSequential(new PushGearCommand(true));
		addSequential(new DriveForTime(-0.5, 1.0));
		// make it so that "isFinished" returns True
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
