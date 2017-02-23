package org.usfirst.frc.team1024.robot.commands.auto;
import org.usfirst.frc.team1024.robot.Robot;
import org.usfirst.frc.team1024.robot.commands.DriveForDistance;

import org.usfirst.frc.team1024.robot.commands.DriveForTime;
import org.usfirst.frc.team1024.robot.commands.GearClampCommand;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.WaitForTimeCommand;
import org.usfirst.frc.team1024.robot.util.Constants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos2GearOnMiddlePeg extends CommandGroup {
	
	
	public Pos2GearOnMiddlePeg() {
		addSequential(new GearClampCommand(0));
		addSequential(new DriveForDistance(Constants.DISTANCE_TO_BASELINE - Constants.ROBOT_LENGTH, 3f));
		addSequential(new WaitForTimeCommand(2.0));
		//addSequential(new DriveForTime(0.5, 3));
		addSequential(new GearClampCommand(1));
		addSequential(new WaitForTimeCommand(0.5));
		addSequential(new PushGearCommand());
		addSequential(new DriveForTime(-0.5, 0.5));
		//make it so that "isFinished" returns True
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
