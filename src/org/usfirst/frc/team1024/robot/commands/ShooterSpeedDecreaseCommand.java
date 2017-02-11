package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterSpeedDecreaseCommand extends Command {
	public ShooterSpeedDecreaseCommand() {
		requires(Robot.gear);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.shooter.shooterPower -= 0.001;
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}