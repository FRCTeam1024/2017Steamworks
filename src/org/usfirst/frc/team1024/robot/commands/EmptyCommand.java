package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.util.CommandBase;

/**
*
* @author Luke Shumaker <lukeshu@sbcglobal.net>
*/
public class EmptyCommand extends CommandBase {
	public EmptyCommand() { super(); }
	protected void initialize() {}
	protected void execute() {}
	protected boolean isFinished() { return true; }
	protected void end() {}
	protected void interrupted() {}
}