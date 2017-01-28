package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *Change Log
 *1/28/2017: Added the blend and stop functions
 */
public class Blender extends Subsystem {
	public final CANTalon blenderMotor = new CANTalon(RobotMap.BLENDER_PORT);
	public Blender() {
		LiveWindow.addActuator("Blender", "Blender Motor", blenderMotor);
	}
	
	public void blend(double power) {
		blenderMotor.set(power);
	}
	
	public void stop() {
		blenderMotor.set(0.0);
	}
	
    public void initDefaultCommand() {
    }
}

