package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnCommand extends CommandGroup {
	
	public TurnCommand(){
		requires(Robot.drivetrain);
	}
	
	@Override
	protected void execute() {
		Robot.drivetrain.turnRelative(0.5, 45); //Set this later
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
	
