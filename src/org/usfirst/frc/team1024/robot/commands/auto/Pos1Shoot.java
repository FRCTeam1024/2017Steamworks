//This class or Pos1Shooting? Or shall they be merged?
package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.Robot;
import org.usfirst.frc.team1024.robot.commands.AgitateCommand;
import org.usfirst.frc.team1024.robot.commands.AutoFlapCommand;
import org.usfirst.frc.team1024.robot.commands.BlendCommand;
import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.ShootCommand;
import org.usfirst.frc.team1024.robot.commands.WaitForTimeCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * GEAR AUTO UNINTENTIONALLY!!!!!!!!!!!!! PogChamp
 * @author team1024
 *
 */
public class Pos1Shoot extends CommandGroup {
	boolean hasDone = false;
	boolean hasDrove = false;
	boolean isDone = false;
	public Pos1Shoot() {/*
		// Drives a little to align with the boiler.
		//addSequential(new DriveForDistance(0.5, 55)); // Set this later
		// Shoots the fuel for 5 seconds. Lengthen this later.
		//addParallel(new ShootCommand(10.0));
		//addParallel(new BlendCommand(10.0));
		//addParallel(new AgitateCommand(10.0));
		addSequential(new AutoFlapCommand());
		addSequential(new ShootCommand());
		addSequential(new WaitForTimeCommand(1));
		addParallel(new ShootCommand());
		addParallel(new BlendCommand());
		addParallel(new AgitateCommand());*/
	}
	
	@Override
	protected void initialize() {}
	
	@Override
	protected void execute() {
		if (hasDone != true) {
			Robot.shooter.shooter.setSetpoint(Robot.shooter.shooterSetSpeed + 400);
			Robot.shooter.shooter.enable();
			Timer.delay(1.0); // for the shooter to get up to speed
			Robot.hopper.flap(true);
			hasDone = true;
		}
		Robot.blender.blend(-1.0);
		Robot.hopper.agitate(1.0);

	}

	@Override
	protected boolean isFinished() { return false; }
	@Override
	protected void end() {
		Robot.shooter.stop();
		Robot.hopper.flap(false);
		//Might have to set stuff to turn off later.
	}
	@Override
	protected void interrupted() {
		end();
	}
	
}
