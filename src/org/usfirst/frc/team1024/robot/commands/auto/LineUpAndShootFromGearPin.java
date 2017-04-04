package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.Robot;
import org.usfirst.frc.team1024.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

// from the red side
public class LineUpAndShootFromGearPin extends CommandGroup {
	boolean hasDone = false;
	
	public LineUpAndShootFromGearPin() {
		//addSequential(new ShiftCommand("High")); // this didn't work; no idea why
		
		//addSequential(new DriveCommand(-0.2, 0.2, 2));  // drive straight back
		
		// turn left (going backwards) a bit, to bring the image into view
		addSequential(new DriveCommand(-0.3, 0.1, 1));  
		
		/*
		 * Currently the problem is that the 2nd DriveCommand doesn't actually drive;
		 * With logging, we can see that the 2nd DriveCommand gets started, but doesn't actually drive; don't know why
		 * The LineUpAndShoot works reasonably well; it lines up fairly well
		 */
		
		addSequential(new LineUpShooter());
	}

	@Override
	protected void initialize() {
	}

	
	@Override
	protected boolean isFinished() { return false; }

	@Override
	protected void end() {
		Robot.shooter.stop();
		Robot.hopper.flip(false);
		Robot.blender.stop();
	}

	@Override
	protected void interrupted() {
	}

}