package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.ShootCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos1Shooting extends CommandGroup{
	
	public Pos1Shooting() {
		
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		//Drives a little to align with the boiler.
		addSequential(new DriveForDistance(0.5, 55)); //Set this later
		//Shoots the fuel.
		addSequential(new ShootCommand());
		
	}
	
	protected boolean isFinished() {
		
		return false;
		
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
