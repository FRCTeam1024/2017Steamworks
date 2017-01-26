package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Changelog:
 * 1/26/17: added climber motors and livewindow stuff
 */
public class Climber extends Subsystem {
	public final CANTalon leftClimber = new CANTalon(RobotMap.LEFT_CLIMBER_PORT);
	public final CANTalon rightClimber = new CANTalon(RobotMap.RIGHT_CLIMBER_PORT);
	public Climber() {
		LiveWindow.addActuator("Climber", "Left Motor", leftClimber);
		LiveWindow.addActuator("Climber", "Right Motor", rightClimber);
	}
    public void initDefaultCommand() {
    }
}

