package org.usfirst.frc.team1024.robot.commands.auto;

import java.sql.Time;
import java.util.List;

import org.usfirst.frc.team1024.Pixy.PixyObject;
import org.usfirst.frc.team1024.robot.Robot;
import org.usfirst.frc.team1024.robot.util.Constants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RedMiddleGearShoot extends CommandGroup {

	boolean hasDone = false;
	boolean hasDrove = false;
	boolean isDone = false;
	boolean hasShot = false;

	public RedMiddleGearShoot() {
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.drivetrain.navx.reset();
		Robot.drivetrain.frontLeftDrive.setEncPosition(0);
		Robot.gear.clamp(-1);
		//Robot.drivetrain.shifter.set(true);
		//Robot.drivetrain.drive(0.5, -0.5);
		Timer time = new Timer();
		time.start();
		/*while(time.get() < 0.94) {
			Robot.drivetrain.driveStraightPower(0.5);
		}*/
		
		while(Robot.drivetrain.frontRightDrive.getDistanceInInches() < 15) { // change this later
			Robot.drivetrain.driveStraightPower(0.5);
		}
		while(Robot.drivetrain.frontRightDrive.getDistanceInInches() < 25) {
			Robot.drivetrain.driveStraightPower(0.3);
		}
		while(Robot.drivetrain.frontRightDrive.getDistanceInInches() < 35) {
			Robot.drivetrain.driveStraightPower(0.1);
		}
		Robot.drivetrain.stop();
		
		Timer.delay(0.5);
		
		Robot.gear.clamp(0);
		time.reset();
		time.start();
		while (time.get() < 2.0) {
			
		}
		time.reset();
		time.start();
		while (time.get() < 0.5) {
			Robot.drivetrain.driveStraightPower(-0.3);
			
		}
		time.reset();
		time.start();
		while (time.get() < 0.5) {
			
		}
		time.reset();
		time.start();
		while(time.get() < 0.3) {
			Robot.drivetrain.drive(-0.3, 0.1);
		}
		Robot.drivetrain.stop();
		
		
		time.reset();
		time.start();
		while (time.get() < 1.0) {
			
		}
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
	protected boolean isFinished() { return isDone; }

	@Override
	protected void end() {
		Robot.shooter.stop();
		Robot.hopper.flip(false);
		Robot.blender.stop();
		// Might have to set stuff to turn off later.
	}

	@Override
	protected void interrupted() {
		end();
	}
}
