package org.usfirst.frc.team1024.robot.commands.auto;
import org.usfirst.frc.team1024.robot.Robot;
import org.usfirst.frc.team1024.robot.commands.AutoFlapCommand;
import org.usfirst.frc.team1024.robot.commands.DriveForDistance;

import org.usfirst.frc.team1024.robot.commands.DriveForTime;
import org.usfirst.frc.team1024.robot.commands.FlapCommand;
import org.usfirst.frc.team1024.robot.commands.GearClampCommand;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.WaitForTimeCommand;
import org.usfirst.frc.team1024.robot.util.Constants;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos2GearOnMiddlePeg extends CommandGroup {
	
	
	public Pos2GearOnMiddlePeg() {
		addSequential(new GearClampCommand(0));
		//addSequential(new DriveForDistance(/*Constants.DISTANCE_TO_BASELINE*/ 114 - Constants.ROBOT_LENGTH, 3f));
		addSequential(new DriveForTime(0.5, 0.5, 1.0)); // drive at half speed for 1 second
		addSequential(new WaitForTimeCommand(0.5));
		//addSequential(new DriveForTime(0.5, 3));
		addSequential(new GearClampCommand(1));
		//addSequential(new AutoFlapCommand());
		addSequential(new WaitForTimeCommand(0.5));
		/*
		addSequential(new PushGearCommand());
		addSequential(new DriveForTime(-0.5, 0.5));
		addSequential(new FlapCommand());
		addSequential(new GearClampCommand(0));
		*/
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
		if (DriverStation.getInstance().isAutonomous()){
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	protected void end() {
	}
	
	@Override
	protected void interrupted() {
	}
}
