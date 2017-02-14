package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootCommand extends Command {

	public ShootCommand() {
		
	}

	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		Robot.shooter.shoot(Robot.shooter.shooterPower);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
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