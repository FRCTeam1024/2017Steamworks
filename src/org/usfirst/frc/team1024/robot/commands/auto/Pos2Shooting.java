package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.ShootCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos2Shooting extends CommandGroup {
	
	public Pos2Shooting() {
		
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		//Drive away from wall
		addSequential(new DriveForDistance(0.5, 33)); //Set this later
		//Turn to face shooting position
		addSequential(new TurnCommand(0.5, -90)); 
		//Drive to shooting position
		addSequential(new DriveForDistance(0.5, 143)); //Set this later
		//Turn to aim shooter at boiler
		addSequential(new TurnCommand(0.5, 45)); //Set this later
		//Shoot until you can't shoot no more
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
