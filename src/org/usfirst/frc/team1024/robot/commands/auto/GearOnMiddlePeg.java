package org.usfirst.frc.team1024.robot.commands.auto;
import org.usfirst.frc.team1024.robot.commands.DriveForDistance;

import org.usfirst.frc.team1024.robot.commands.DriveForTime;
import org.usfirst.frc.team1024.robot.commands.GearClampCommand;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.util.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GearOnMiddlePeg extends CommandGroup {
	public GearOnMiddlePeg() {
		addSequential(new DriveForDistance(0.5, Constants.DISTANCE_TO_BASELINE - Constants.ROBOT_WIDTH));
		//addSequential(new GearClampCommand());
		addSequential(new PushGearCommand(true));
		addSequential(new DriveForTime(-0.5, 1.0));
	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
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
