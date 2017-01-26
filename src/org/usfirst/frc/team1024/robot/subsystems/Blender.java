package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Blender extends Subsystem {
	public final CANTalon blenderMotor = new CANTalon(RobotMap.BLENDER_PORT);
	public Blender() {
		LiveWindow.addActuator("Blender", "Blender Motor", blenderMotor);
	}
    public void initDefaultCommand() {
    }
}

