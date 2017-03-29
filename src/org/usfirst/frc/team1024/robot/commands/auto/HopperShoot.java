package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.commands.AutoFlapCommand;
import org.usfirst.frc.team1024.robot.commands.DriveCommand;
import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;
import org.usfirst.frc.team1024.robot.commands.WaitForTimeCommand;
import org.usfirst.frc.team1024.robot.util.Constants;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 * Coded in the car in 15 minutes | 8:04 PM 2/28/17
 * @author team1024
 *
 */
public class HopperShoot extends CommandGroup {
	public HopperShoot() {
		// flaps up
		addSequential(new AutoFlapCommand()); 
		// drive a distance to be perpendicular with the hopper
		addSequential(new DriveForDistance(Constants.DISTANCE_TO_BOILER_HOPPER_SWITCH - Constants.ROBOT_LENGTH, 3f));
		// turn 90 degrees
		addSequential(new TurnCommand(0.5, -90));
		// go forward a footish
		addSequential(new DriveForDistance(12, 1f));
		// wait for a time
		addSequential(new WaitForTimeCommand(5)); //probs needs to be shorter
		//backup
		addSequential(new DriveForDistance(-12, 1f));
		//turn towards boiler
		addSequential(new TurnCommand(0.5, -90));
		//drive to boilder
		addSequential(new DriveForDistance(109, 3f));
		//SPLIT RED AND BLUE
		//ASSUME ALIGN WITH BOILER IS CORRECT
		//just run right side to get flush with boiler
		addSequential(new DriveCommand(0.0, 0.5, 1f));
		//shoot until the end
		addSequential(new Pos1Shoot());

	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		if (DriverStation.getInstance().isAutonomous()) {
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