package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RedPos1ShootCrossArcOppositeSide extends CommandGroup {

	boolean hasDone = false;
	boolean hasDrove = false;
	boolean isDone = false;
	boolean hasShot = false;

	public RedPos1ShootCrossArcOppositeSide() {
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if (isDone != true) {
			if (hasShot != true) {
				Robot.shooter.shooter.setSetpoint(Robot.shooter.shooterSetSpeed + 200); // have to add more
																						// because we are further away than anticipated
				Robot.shooter.shooter.enable();
				Timer.delay(2.5); // for the shooter to get up to speed
				Robot.hopper.flap(true);
				hasDone = true;
			}
			Robot.blender.blend(-0.5);
			Robot.hopper.agitate(1.0);
			Timer.delay(10);
			Robot.blender.stop();
			Robot.hopper.agitator.set(0.0);
			Robot.shooter.stop();

			Robot.drivetrain.drive(0.5, 0.0);
			Timer.delay(1);
			Robot.drivetrain.drive(-0.5, 0.8);
			Timer.delay(1);
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
