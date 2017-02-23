package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class BlendCommand extends Command {
	double time;
	boolean isDone;
	public BlendCommand(double time) {
		this.time = time;
	}
	
	@Override
	protected void initialize() {}
	
	@Override
	protected void execute() {
		Robot.blender.blend(1.0);
		Timer.delay(time);
		isDone = true;
	}
	
	@Override
	protected boolean isFinished() {
		return isDone;
	}
	@Override
	protected void end() {
		Robot.blender.stop();
	}
	@Override
	protected void interrupted() {
		Robot.blender.stop();
	}

}
