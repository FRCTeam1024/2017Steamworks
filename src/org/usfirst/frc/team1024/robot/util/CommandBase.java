package org.usfirst.frc.team1024.robot.util;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The base for all commands, also the class defining robot hardware/config.
 * All atomic commands should subclass CommandBase. CommandBase stores creates
 * and stores each control system.
 * 
 * @author Luke Shumaker <lukeshu@sbcglobal.net>
 */
public abstract class CommandBase extends Command {

	private boolean has_subsystems = true;
	protected synchronized void requires(Subsystem subsystem) {
		if (subsystem == null) {
			has_subsystems = false;
		}
		super.requires(subsystem);
	}
	
	public synchronized void start() {
		if (has_subsystems) { super.start(); }
	}
	
	public CommandBase() { super(); }
	public CommandBase(double timeout) { super(timeout); }
	public CommandBase(String name) { super(name); }
	public CommandBase(String name, double timeout) { super(name, timeout); }
}