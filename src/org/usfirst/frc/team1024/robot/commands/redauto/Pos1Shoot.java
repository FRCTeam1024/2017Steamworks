//This class or Pos1Shooting? Or shall they be merged?
package org.usfirst.frc.team1024.robot.commands.redauto;

import org.usfirst.frc.team1024.robot.Robot;
import org.usfirst.frc.team1024.robot.commands.AgitateCommand;
import org.usfirst.frc.team1024.robot.commands.BlendCommand;
import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.ShootCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos1Shoot extends CommandGroup {
	boolean hasDone = false;
	public Pos1Shoot() {
		// Drives a little to align with the boiler.
		//addSequential(new DriveForDistance(0.5, 55)); // Set this later
		// Shoots the fuel for 5 seconds. Lengthen this later.
		//addParallel(new ShootCommand(10.0));
		//addParallel(new BlendCommand(10.0));
		//addParallel(new AgitateCommand(10.0));
	}
	
	@Override
	protected void initialize() {}
	
	@Override
	protected void execute() {
		if (hasDone != true) {
			Robot.shooter.shooter.setSetpoint(Robot.shooter.shooterSetSpeed);
			Timer.delay(0.5); //for the shooter to get up to speed
			hasDone = true;
		}
		Robot.blender.blend(-1.0);
		Robot.hopper.agitate(1.0);
	}
	
	@Override
	protected boolean isFinished() { return false; }
	@Override
	protected void end() {
	}
	@Override
	protected void interrupted() {}
	
}
