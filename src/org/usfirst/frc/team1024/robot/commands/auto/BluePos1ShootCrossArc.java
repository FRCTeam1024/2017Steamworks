package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class BluePos1ShootCrossArc extends CommandGroup {

	boolean hasDone = false;
	boolean hasDrove = false;
	boolean isDone = false;
	boolean hasShot = false;

	public BluePos1ShootCrossArc() {/*
									 * // Drives a little to align with the
									 * boiler. //addSequential(new
									 * DriveForDistance(0.5, 55)); // Set this
									 * later // Shoots the fuel for 5 seconds.
									 * Lengthen this later. //addParallel(new
									 * ShootCommand(10.0)); //addParallel(new
									 * BlendCommand(10.0)); //addParallel(new
									 * AgitateCommand(10.0)); addSequential(new
									 * AutoFlapCommand()); addSequential(new
									 * ShootCommand()); addSequential(new
									 * WaitForTimeCommand(1)); addParallel(new
									 * ShootCommand()); addParallel(new
									 * BlendCommand()); addParallel(new
									 * AgitateCommand());
									 */
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if (isDone != true) {

			if (hasShot != true) {
				Robot.shooter.shooter.setSetpoint(Robot.shooter.shooterSetSpeed + 105);
				Robot.shooter.shooter.enable();
				Timer.delay(1.0); // for the shooter to get up to speed
				Robot.hopper.flap(true);
				hasDone = true;
			}
			Robot.blender.blend(-0.4);
			Robot.hopper.agitate(1.0);
			Timer.delay(10);
			Robot.blender.stop();
			Robot.hopper.agitator.set(0.0);
			Robot.shooter.stop();

			Robot.drivetrain.drive(0.0, -0.5);
			Timer.delay(1);
			Robot.drivetrain.drive(-0.8, 0.5);
			Timer.delay(1.0);
			Robot.drivetrain.stop();
			isDone = true;
		}
	}
	@Override
	protected boolean isFinished() { return false; }

	@Override
	protected void end() {
		Robot.shooter.stop();
		Robot.hopper.flap(false);
		// Might have to set stuff to turn off later.
	}

	@Override
	protected void interrupted() {
		end();
	}

}
