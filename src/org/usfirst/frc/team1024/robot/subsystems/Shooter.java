package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Changelog:
 * 1/26/17: added shooter motor and livewindow stuff
 */
public class Shooter extends Subsystem {
	public final CANTalon shooter = new CANTalon(RobotMap.SHOOTER_PORT);
	public Shooter() {
		LiveWindow.addActuator("Shooter", "Shooter Motor", shooter);
	}
    public void initDefaultCommand() {
    }
}

