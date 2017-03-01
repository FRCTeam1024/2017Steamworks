package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ShootCommand extends Command {
	boolean isDone = false;
	int type;
	double time;
	public ShootCommand() {
		requires(Robot.shooter);
		type = 0;
	}
	
	public ShootCommand(double time) {
		requires(Robot.shooter);
		this.time = time;
		type = 1;
	}

	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		switch (type) {
			case 0:
				Robot.shooter.shooter.setSetpoint(Robot.shooter.shooterSetSpeed);
				Robot.shooter.shooter.enable();
				break;
			case 1:
				Robot.shooter.shooter.setSetpoint(Robot.shooter.shooterSetSpeed);
				Robot.shooter.shooter.enable();
				Timer.delay(time);
				isDone = true;
				break;
		}
		
	}
	
	@Override
	protected boolean isFinished() {
		return false; //We always want this to run forever until the command is canceled
	}
	
	@Override
	protected void end() {
		Robot.shooter.stop();
	}
	
	@Override
	protected void interrupted() {
		Robot.shooter.stop();
	}

}