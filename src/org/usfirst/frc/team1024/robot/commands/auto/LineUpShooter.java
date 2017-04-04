package org.usfirst.frc.team1024.robot.commands.auto;

import java.util.List;

import org.usfirst.frc.team1024.Pixy.PixyObject;
import org.usfirst.frc.team1024.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LineUpShooter extends Command {
	
	boolean isDone = false;
	
	public LineUpShooter() {
		log("starting LineUpShooter");
	}

	@Override
	protected void execute() {
		
		List<PixyObject> pixyObjectList = Robot.getPixyObjects(1);
//		Robot.drivetrain.drive(-0.2, -0.2);
		if (pixyObjectList != null ) {
			Robot.printPixyStuff(pixyObjectList);
//			System.out.println("Got " + pixyObjectList.size() + " objects from the pixy");
			for (int i = 0; i < pixyObjectList.size(); i++) {
				log(pixyObjectList.get(i).toString());
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
					Robot.drivetrain.stop();
					
					// lines below here should be in a separate Command
					// or maybe not, if we start the shooter spinning while we are doing this;
					// but you could also do that with addParallel commands
					Robot.shooter.shooter.setSetpoint(Robot.shooter.shooterSetSpeed + 1000);
					Robot.shooter.shooter.enable();
					
					Timer.delay(1.0); // for the shooter to get up to speed
					Robot.hopper.flip(true);  // why is this here? copied from LineUpAndShoot
					
					Timer.delay(1.0);
					
					Robot.blender.blend(-0.5);
					Robot.hopper.agitate(1.0);
					Timer.delay(5);
					isDone = true;
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
}
