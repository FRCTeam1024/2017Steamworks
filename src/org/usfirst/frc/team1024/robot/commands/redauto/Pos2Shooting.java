package org.usfirst.frc.team1024.robot.commands.redauto;

import org.usfirst.frc.team1024.robot.commands.Drive2Inputs;
import org.usfirst.frc.team1024.robot.commands.DriveForDistance;
import org.usfirst.frc.team1024.robot.commands.ShootCommand;
import org.usfirst.frc.team1024.robot.commands.TurnCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos2Shooting extends CommandGroup {
	
	
	public Pos2Shooting() {
		
		//Drive away from wall
		addSequential(new DriveForDistance(0.5, 33)); //Set this later
		//Turn to face the boiler
		addSequential(new TurnCommand(0.5, -90)); 
		//Drive to shooting position
		addSequential(new DriveForDistance(0.5, 95)); //Set this later
		//Turn to aim shooter at boiler
		addSequential(new Drive2Inputs(1.0, 0, 135)); //Takes right and left power, along with desired gyro angle. Check if valid
		//Shoot
		addSequential(new ShootCommand());
		
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
	
	}
	
	protected boolean isFinished() {
		
		return false;
		
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
}
