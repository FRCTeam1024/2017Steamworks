package org.usfirst.frc.team1024.robot.commands.auto;

import java.util.List;

import org.usfirst.frc.team1024.Pixy.PixyObject;
import org.usfirst.frc.team1024.robot.Robot;
import org.usfirst.frc.team1024.robot.commands.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// from the red side
public class LineUpAndShootFromGearPin extends CommandGroup {
	boolean hasDone = false;
	boolean isDone = false;

	public LineUpAndShootFromGearPin() {
		// addSequential(new ShiftCommand("High")); // this didn't work; no idea
		// why

		// addSequential(new DriveCommand(-0.2, 0.2, 2)); // drive straight back

		// turn left (going backwards) a bit, to bring the image into view
		// addSequential(new DriveCommand(-0.3, 0.1, 1));

		/*
		 * Currently the problem is that the 2nd DriveCommand doesn't actually
		 * drive; With logging, we can see that the 2nd DriveCommand gets
		 * started, but doesn't actually drive; don't know why The
		 * LineUpAndShoot works reasonably well; it lines up fairly well
		 */

		// addSequential(new LineUpShooter());
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Robot.drivetrain.drive(-0.3, 0.1);
		Timer.delay(0.5);
		Robot.drivetrain.stop();
		while (!isDone && !Robot.oi.getBreakButton()) {

			List<PixyObject> pixyObjectList = Robot.getPixyObjects(1);
			// Robot.drivetrain.drive(-0.2, -0.2);
			if (pixyObjectList != null) {
				Robot.printPixyStuff(pixyObjectList);
				// System.out.println("Got " + pixyObjectList.size() + " objects
				// from the pixy");
				for (int i = 0; i < pixyObjectList.size(); i++) {
					log(pixyObjectList.get(i).toString());
				}

				// get first object
				if (pixyObjectList.size() > 0) {
					SmartDashboard.putNumber("Drive Multiplier", Robot.driveMultiplier);
					PixyObject pixyObject = pixyObjectList.get(0);
					Robot.pixyX = pixyObject.getX();
					if (Robot.pixyX > 150) {
						Robot.drivetrain.drive(Robot.driveMultiplier * 0.2, Robot.driveMultiplier * 0.2); // turn
																											// left
					} else if (Robot.pixyX < 130) {
						Robot.drivetrain.drive(Robot.driveMultiplier * -0.2, Robot.driveMultiplier * -0.2); // turn
																											// right
					} else {
						// Robot.times++;
						Robot.drivetrain.stop();
						// if (Robot.times > 5) {

						// lines below here should be in a separate Command
						// or maybe not, if we start the shooter spinning
						// while
						// we are doing this;
						// but you could also do that with addParallel
						// commands
						Robot.shooter.shooter.setSetpoint(Robot.shooter.shooterSetSpeed + 900);
						Robot.shooter.shooter.enable();
						
						Timer.delay(1);
						
						Robot.blender.blend(-0.5);
						Robot.hopper.agitate(1.0);
						Timer.delay(5);
						isDone = true;

					}
				}
			}
		}

	}

	private void log(String msg) {
		System.out.println(msg);
	}

	@Override
	protected boolean isFinished() {
		return isDone;
	}

	@Override
	protected void end() {
		log("ending LineUpShooter Command");
		Robot.shooter.stop();
		Robot.hopper.flip(false);
		Robot.blender.stop();
	}

	@Override
	protected void interrupted() {
	}

}