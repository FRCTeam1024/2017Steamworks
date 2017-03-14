package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.Robot;
import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.PushGearCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossBaselinePower extends CommandGroup {
	boolean isDone = false;
	public CrossBaselinePower() {
	
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.drivetrain.frontLeftDrive.changeControlMode(TalonControlMode.PercentVbus);
		Robot.drivetrain.frontRightDrive.changeControlMode(TalonControlMode.PercentVbus);
		Robot.drivetrain.drive(1.0, -1.0);
		Timer.delay(1);
		Robot.drivetrain.stop();
		isDone = true;
	}

	@Override
	protected boolean isFinished() {
		return isDone;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}