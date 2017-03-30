package org.usfirst.frc.team1024.robot.commands.redauto;

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
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RedPos1ShootCross extends CommandGroup {

	boolean hasDone = false;
	boolean hasDrove = false;
	boolean isDone = false;

	public RedPos1ShootCross() {/*
								 * // Drives a little to align with the boiler.
								 * //addSequential(new DriveForDistance(0.5,
								 * 55)); // Set this later // Shoots the fuel
								 * for 5 seconds. Lengthen this later.
								 * //addParallel(new ShootCommand(10.0));
								 * //addParallel(new BlendCommand(10.0));
								 * //addParallel(new AgitateCommand(10.0));
								 * addSequential(new AutoFlapCommand());
								 * addSequential(new ShootCommand());
								 * addSequential(new WaitForTimeCommand(1));
								 * addParallel(new ShootCommand());
								 * addParallel(new BlendCommand());
								 * addParallel(new AgitateCommand());
								 */
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Timer time = new Timer();
		time.reset();
		time.start();
		double startTime = time.get();
		while (time.get() < startTime + 10.5 && Robot.oi.getBreakButton() == false) {
			if (hasDone != true) {
				Robot.shooter.shooter.setSetpoint(Robot.shooter.shooterSetSpeed + 105);
				Timer.delay(1.0); // for the shooter to get up to speed
				Robot.hopper.flap(true);
				hasDone = true;
			}
			Robot.blender.blend(-0.4);
			Robot.hopper.agitate(1.0);
		}
		while (hasDrove != true && Robot.oi.getBreakButton() == false) {
			Robot.drivetrain.drive(-1.0, 0.0);
			Timer.delay(1);
			Robot.drivetrain.drive(1.0, -1.0);
			Timer.delay(2);
			Robot.drivetrain.stop();
			hasDrove = true;
			isDone = true;
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.shooter.stop();
		Robot.hopper.flap(false);
		// Might have to set stuff to turn off later.
	}

	@Override
	protected void interrupted() {
	}
}