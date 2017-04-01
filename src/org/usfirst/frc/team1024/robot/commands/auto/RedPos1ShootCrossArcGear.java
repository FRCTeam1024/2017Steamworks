package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RedPos1ShootCrossArcGear extends CommandGroup {

	boolean hasDone = false;
	boolean hasDrove = false;
	boolean isDone = false;
	boolean hasShot = false;

	public RedPos1ShootCrossArcGear() {/*
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
				hasDone = true;
			}
			Robot.blender.blend(-0.5);
			Robot.hopper.agitate(1.0);
			
			
			Timer.delay(5);
			Robot.blender.stop();
			Robot.hopper.agitator.set(0.0);
			Robot.shooter.stop();

			Robot.drivetrain.drive(0.5, 0.0);
			Timer.delay(1);
			Robot.drivetrain.drive(-0.4, 0.8);
			Timer.delay(1);
			Robot.drivetrain.drive(0.6, -0.3);
			Timer.delay(1);
			Robot.drivetrain.drive(0.43, -0.4);
			Timer.delay(0.75);
			Robot.drivetrain.stop();
			isDone = true;
		}
	}
	@Override
	protected boolean isFinished() { return false; }

	@Override
	protected void end() {
		Robot.shooter.stop();
		Robot.hopper.flip(false);
		// Might have to set stuff to turn off later.
	}

	@Override
	protected void interrupted() {
		end();
	}

}
