package org.usfirst.frc.team1024.robot.commands.auto;

import java.util.List;

import org.usfirst.frc.team1024.Pixy.PixyObject;
import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LineUpAndShoot extends Command {
	boolean hasDone = false;
	
	public LineUpAndShoot() {
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		List<PixyObject> pixyObjectList = Robot.getPixyObjects();
		Robot.drivetrain.drive(-0.2, -0.2);
		if (pixyObjectList != null ) {
			Robot.printPixyStuff(pixyObjectList);
			System.out.println("Got " + pixyObjectList.size() + " objects from the pixy");
			for (int i = 0; i < pixyObjectList.size(); i++) {
				DriverStation.reportError(pixyObjectList.get(i).toString(), false);
			}
			
			// get first object
			if (pixyObjectList.size() > 0) {
				SmartDashboard.putNumber("Drive Multiplier", Robot.driveMultiplier);
				PixyObject pixyObject = pixyObjectList.get(0);
				Robot.pixyX = pixyObject.getX();
				if (Robot.pixyX > 170) {
					Robot.drivetrain.drive(Robot.driveMultiplier * 0.2, Robot.driveMultiplier * 0.2); // turn left
				} else if (Robot.pixyX < 150) {
					Robot.drivetrain.drive(Robot.driveMultiplier * -0.2, Robot.driveMultiplier * -0.2); // turn right
				} else {
					Robot.driveMultiplier *= 0.8;
					Robot.drivetrain.stop();
					Robot.times++;
					SmartDashboard.putNumber("Times", Robot.times);
					Robot.shooter.shooter.setSetpoint(Robot.shooter.shooterSetSpeed + 1000);
					Robot.shooter.shooter.enable();
					if (Robot.times > 5) {
						if (hasDone != true) {
							
							//Timer.delay(1.0); // for the shooter to get up to speed
							Robot.hopper.flip(true);
							hasDone = true;
						}
						Robot.blender.blend(-0.5);
						Robot.hopper.agitate(1.0);
						Timer.delay(10);
						end();
					}
				}
			}
		}
		
		
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