package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AgitateCommand extends Command {
	int type;
	double time;
	boolean isDone = false;
	public AgitateCommand() {
		type = 0;
	}
	public AgitateCommand(double time) {
		this.time = time;
		type = 1;
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		switch (type) {
			case 0:
				Robot.hopper.agitate(1.0);
				break;
			case 1:
				Robot.hopper.agitate(1.0);
				Timer.delay(time);
				isDone = true;
				break;
		}
		
	}
	
	@Override
	protected boolean isFinished() {
		return false; //We always want this to run forever until the command is canceled
	}
	
	@Override
	protected void end() {
		Robot.hopper.agitate(0.0);
	}
	
	@Override
	protected void interrupted() {
		Robot.hopper.agitate(0.0);
	}
}
