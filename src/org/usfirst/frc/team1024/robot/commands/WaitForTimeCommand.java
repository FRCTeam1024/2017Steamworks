package org.usfirst.frc.team1024.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class WaitForTimeCommand extends Command{
	double seconds;
	boolean isDone;
	public WaitForTimeCommand(double seconds) { 
		this.seconds = seconds;
	}
	protected void initialize() {
		
	}
	protected void execute() {
		Timer.delay(seconds);
		isDone = true;
	}
	protected boolean isFinished() { 
		return isDone;
	}
	protected void end() {
		
	}
	protected void interrupted() {
		
	}

}
