package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class OpenClampPushGearCommand extends Command {
	boolean isDone = false;
	public OpenClampPushGearCommand() {
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		
		if (Robot.oi.logi.getRawButton(7)) {
			Robot.hopper.flap(true);
			Timer.delay(0.2);
			Robot.gear.push(true);
			Robot.gear.clamp(1);
		} else {
			Robot.hopper.flap(false);
			Robot.gear.push(false);
			Robot.gear.clamp(0);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return isDone;
	}
	
	@Override
	protected void end() {
		Robot.hopper.flap(false);
		Robot.gear.clamp(0);
		Robot.gear.push(false);
	}
	
	@Override
	protected void interrupted() {
		Robot.hopper.flap(false);
		Robot.gear.clamp(0);
		Robot.gear.push(false);
	}
}