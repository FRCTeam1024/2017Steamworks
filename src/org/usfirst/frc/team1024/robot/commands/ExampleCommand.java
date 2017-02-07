package org.usfirst.frc.team1024.robot.commands;
import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
public class ExampleCommand extends Command {
	public ExampleCommand() {
	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		//Drive straight to a peg
		Robot.drivetrain.driveForDistance(98.3, 0.5);
		//Drive to boiler
		Robot.drivetrain.driveForTime(2.5, 0.4, 0.4);//Set this later
		//Robot.shooter.shoot();
		//Robot.drivetrain.turnLeft(0.5, 45); //Set this angle later
		Robot.drivetrain.driveForDistance(90, 0.4); //Set this distance later
		//
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
