package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Change Log:
 * 1/26/17: added climber motors and Livewindow stuff
 * 1/28/2017: Added the climb(power), stop, getCurrent, eStop, override, and climb(preset) commands
 */
public class Climber extends Subsystem {
	public final CANTalon leftClimber = new CANTalon(RobotMap.LEFT_CLIMBER_PORT);
	public final CANTalon rightClimber = new CANTalon(RobotMap.RIGHT_CLIMBER_PORT);
	public Climber() {
		LiveWindow.addActuator("Climber", "Left Motor", leftClimber);
		LiveWindow.addActuator("Climber", "Right Motor", rightClimber);
	}
	
	public void climb(double power) {
		
	}
	
	public void stop() {
		leftClimber.set(0.0);
		rightClimber.set(0.0);
	}
	
	public void getCurrent() {
	}
	
	//
	public void emergencyStop() {
		//if(
	}
	
	//"override" is a Java key word. "OverrideSafety" will reduce confusion.
	public void overrideSafety() {
		
	}
	
	public void climb() {
		leftClimber.set(1.0); // Set this later
		rightClimber.set(1.0); // Set this later
	}
	
    public void initDefaultCommand() {
    }
}

