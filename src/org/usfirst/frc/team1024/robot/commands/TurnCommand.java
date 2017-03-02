package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnCommand extends CommandGroup {
	double power;
	double angleChange;
	public TurnCommand(double power, double angleChange){
		requires(Robot.drivetrain);
		this.power = power;
		this.angleChange = angleChange;
	}
	
	@Override
	protected void execute() {
		System.out.println("IN Turn");
		Robot.drivetrain.turnRelative(power, angleChange); //Set this later
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
	
