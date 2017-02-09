package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.subsystems.Gear;

import edu.wpi.first.wpilibj.command.Command;

public class PushGearCommand extends Command {
	Gear gear;
	
	public PushGearCommand(Gear gear) {
		super("PushGearCommand");
		requires(gear);
	}
	
	@Override
	protected boolean isFinished() {
		
		// TODO Auto-generated method stub
		
		return false;
		
	}
	
	@Override
	protected void execute() {
		// TODO Execute the "PushGear" code
	}
	
}
